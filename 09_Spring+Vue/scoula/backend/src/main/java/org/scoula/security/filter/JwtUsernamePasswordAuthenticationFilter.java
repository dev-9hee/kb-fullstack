package org.scoula.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.scoula.security.account.dto.LoginDTO;
import org.scoula.security.handler.LoginFailureHandler;
import org.scoula.security.handler.LoginSuccessHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    // 스프링 생성자 주입을 통해 전달
    // 로그인 요청을 처리하고, 인증 성공 및 실패를 처리하는 핸들러를 설정
    // 생성자 주입을 통해 필요한 의존성을 주입받으며, 특정 URL 경로에 대한 로그인 요청을 처리하도록 설정
    public JwtUsernamePasswordAuthenticationFilter(
            AuthenticationManager authenticationManager, // SecurityConfig 가 생성된 이후에 등록됨, 주로 인증 설정에서 제공
            LoginSuccessHandler loginSuccessHandler,
            LoginFailureHandler loginFailureHandler
    ) {
        super(authenticationManager); // 부모 클래스의 생성자에게 authenticationManager 를 전달

        setFilterProcessesUrl("/api/auth/login"); // POST 로그인 요청 url, 이 URL 에 대한 로그인 요청이 필터에 의해 인증 처리
        setAuthenticationSuccessHandler(loginSuccessHandler); // 로그인 성공 핸들러 등록
        setAuthenticationFailureHandler(loginFailureHandler); // 로그인 실패 핸들러 등록
    }

    // 로그인 요청 URL 인 경우 로그인 작업 처리
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        // 요청 BODY 의 JSON 에서 username, password -> LoginDTO
        // 요청 본문에서 JSON 형식의 로그인 정보를 추출하고, 이를 LoginDTO 객체로 변환
        LoginDTO login = LoginDTO.of(request);

        // 인증 토큰(UsernamePasswordAuthenticationToken) 구성
        // Spring Security 에서 사용자 인증을 처리하는 데 사용되는 토큰 객체
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());

        // AuthenticationManager 에게 인증 요청
        // 주어진 인증 토큰을 사용하여 사용자 인증을 수행하고, 인증 결과를 Authentication 객체로 반환
        return getAuthenticationManager().authenticate(authenticationToken);
    }
}
