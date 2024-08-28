package org.example.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.example.security.service.CustomUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity // 중요! Spring Security 를 적용하겠다
@RequiredArgsConstructor
@Log4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder; // 암호화를 위함

    // 문자셋필터
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true); // 무슨 요청이 들어와도 UTF-8 으로 인코딩 설정
        return encodingFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 권한 순서대로 적용됨
        http.authorizeRequests() // http 리퀘스트에 대해서 인증 여부를 체크하는 메서드
                .antMatchers("/").permitAll() // 인증 없이 접근 가능
                .antMatchers("/user/**").permitAll()
                .antMatchers("/security/admin/**").access("hasRole('ROLE_ADMIN')") // 관리자 접근
                .antMatchers("/security/**").permitAll()
                .antMatchers("/kakao/**").permitAll() // 카카오 로그인 사용 가능
                .antMatchers("/**").access("hasAnyRole('ROLE_MEMBER', 'ROLE_KAKAO')"); // 특정 role 을 가지고 있을 때만

        // MVC 패턴에서의 로그인 설정
        http.formLogin()
                .loginPage("/security/login") // 로그인 GET URL
                .loginProcessingUrl("/security/login") // 로그인 POST URL -> login form 의 action 에 지정
                .defaultSuccessUrl("/security/member") // 로그인 성공 시 이동(redirect) 할 페이지
                .failureUrl("/security/login-failed"); // 로그인 실패 시

        http.addFilterBefore(encodingFilter(), CsrfFilter.class); // 한글 처리는 CsrfFilter 를 거치기 전에 수행

        http.logout()
                .logoutUrl("/security/logout")
                .invalidateHttpSession(true) // 세션 만료
                .deleteCookies("remember-me", "JSESSIONID") // 쿠키 삭제
                .logoutSuccessUrl("/security/login")
                .permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 방금 만든 서비스와 암호화 도구를 기본으로 사용자 인증에 사용하겠다고 설정
        auth.userDetailsService(customUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
}
