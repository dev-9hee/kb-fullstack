package org.scoula.security.config;

import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity // Spring Security 의 웹 보안 지원을 활성화
@Log4j
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
public class SecurityConfig extends WebSecurityConfigurerAdapter { // 웹 애플리케이션의 보안 정책을 설정하는 데 사용, 커스텀 보안 설정을 쉽게 정의

    @Bean
    public PasswordEncoder passwordEncoder() { // 비밀번호는 반드시 암호화해서 처리
        return new BCryptPasswordEncoder(); // 구현체
    }

    // 문자셋 필터
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8"); // 문자 인코딩을 UTF-8로 설정
        encodingFilter.setForceEncoding(true); // 모든 요청에 대해 이 인코딩을 강제로 사용
        return encodingFilter;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 이 필터를 Spring Security 필터 체인에 추가
        http.addFilterBefore(encodingFilter(), CsrfFilter.class); // 문자 인코딩 필터를 CsrfFilter 보다 앞에 등록 필요

        // 경로별 접근 권한 설정
        http.authorizeRequests()
                .antMatchers("/security/all").permitAll() // 모두 허용
                // 특정 역할에게만 허용
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");

        // 로그인 폼 설정, form 기반 로그인 활성화, 요청 파라미터의 이름이 정해져있음 (username, password)
        http.formLogin() // 로그인 설정 시작
                // 로그인 페이지 커스트마이징, 생략하면 디폴트 값으로 설정됨
                .loginPage("/security/login") // 로그인 페이지 GET URL -> security/login 뷰(jsp) 정의
                .loginProcessingUrl("/security/login") // 로그인 POST URL -> login form 의 action 에 지정
                .defaultSuccessUrl("/"); // 로그인 성공 시 이동(redirect) 할 페이지
        // 설정후 /security/member,admin => /login 으로 리다이렉트

        // 로그아웃 설정, logout url 을 post 로 요청!!
        // 세션 무효화, 쿠키 제거!!!! 필수
        http.logout()
                .logoutUrl("/security/logout") // POST: 로그아웃 호출 url
                .invalidateHttpSession(true) // 세션 invalidate
                .deleteCookies("remember-me", "JSESSION-ID") // 삭제할 쿠키 목록
                .logoutSuccessUrl("/security/logout"); // GET: 로그아웃 이후 이동할 페이지
    }

    // 인증 정보 설정, admin 또는 member 로 로그인 가능
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure .........................................");

        auth.inMemoryAuthentication() // 메모리에서 사용자 정보 설정
                .withUser("admin") // username, 사용자 id
                //.password("{noop}1234") // 비밀번호, {noop}는 암호화 없음 의미
                .password("$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC")
                .roles("ADMIN","MEMBER"); // ROLE_ADMIN, ROLE_MEMBER

        auth.inMemoryAuthentication()
                .withUser("member")
//                .password("{noop}1234")
                .password("$2a$10$EsIMfxbJ6NuvwX7MDj4WqOYFzLU9U/lddCyn0nic5dFo3VfJYrXYC")
                .roles("MEMBER"); // ROLE_MEMBER
    }
}