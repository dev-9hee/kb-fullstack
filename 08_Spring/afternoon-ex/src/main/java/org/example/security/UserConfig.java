package org.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserConfig implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() { // 암호화 라이브러리 등록
        return new BCryptPasswordEncoder();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("시큐리티 인터셉터가 등록되었습니다.");
        registry.addInterceptor(new AuthenticationInterceptor()) // 클래스를 직접 생성해서 넣음
                .addPathPatterns("/**") // 모든 주소에 대한 접근에 로그인 여부를 확인
                // 기본주소와 로그인을 위한 /user 의 하위 주소는 예외로 등록하여 접근이 가능하도록 설정
                .excludePathPatterns("/", "/user/**", "/resources/**");
    }
}
