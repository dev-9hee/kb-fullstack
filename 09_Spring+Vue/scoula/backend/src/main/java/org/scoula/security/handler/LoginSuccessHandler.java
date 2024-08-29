package org.scoula.security.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.dto.AuthResultDTO;
import org.scoula.security.account.dto.UserInfoDTO;
import org.scoula.security.util.JsonResponse;
import org.scoula.security.util.JwtProcessor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 인증 성공시 접근 토큰과 사용자 정보를 json 으로 응답
@Log4j
@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtProcessor jwtProcessor;

    // 인증 결과를 구성하기 위한 메서드
    // 사용자 정보를 기반으로 JWT 토큰과 사용자 기본 정보를 포함하는 AuthResultDTO 객체를 생성
    // 이 메서드는 인증이 성공한 후 클라이언트에게 반환할 데이터 구조를 준비하는 데 사용
    // AuthResultDTO : 인증 결과를 담는 데이터 전송 객체(DTO) / CustomUser : 인증된 사용자 정보를 담고 있는 CustomUser 객체
    private AuthResultDTO makeAuthResult(CustomUser user) {
        String username = user.getUsername(); // 이 이름은 토큰 생성에 사용
        // 토큰 생성, 사용자 이름을 입력으로 받아, 이 사용자에 대한 JWT 토큰을 반환
        String token = jwtProcessor.generateToken(username);
        // 토큰 + 사용자 기본 정보 (사용자명, ...)를 묶어서 AuthResultDTO 구성
        return new AuthResultDTO(token, UserInfoDTO.of(user.getMember()));
    }

    // Spring Security 의 인증 성공 핸들러로, 사용자가 로그인에 성공했을 때 호출
    // 성공적인 인증 후에 클라이언트에게 JSON 형식으로 응답을 전송하는 역할
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 인증 결과 Principal
        CustomUser user = (CustomUser) authentication.getPrincipal(); // 인증된 사용자의 정보를 가져옴

        // 인증 성공 결과를 JSON 으로 직접 응답
        // 이 객체는 사용자 정보와 JWT 토큰을 포함하며, 인증이 성공한 결과를 담고 있음
        AuthResultDTO result = makeAuthResult(user);
        JsonResponse.send(response, result); // AuthResultDTO 객체를 JSON 형식으로 변환하고, HTTP 응답 본문에 작성하여 클라이언트에게 전송
    }
}
