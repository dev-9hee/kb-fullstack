package org.scoula.security.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.security.util.JwtProcessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
// 요청당 한 번만 필터가 동작하도록 설정하는 Spring Security 의 필터 클래스 상속
public class JwtAuthenticationFilter extends OncePerRequestFilter { // 요청당 한 번만 필터가 동작하도록 해줌
    public static final String  AUTHORIZATION_HEADER = "Authorization"; // Authorization 헤더의 이름을 상수로 정의
    public static final String  BEARER_PREFIX = "Bearer "; // 토큰 앞에 붙는 Bearer 문자열을 상수로 정의, 끝에 공백 있음

    private final JwtProcessor jwtProcessor; // JWT 토큰을 처리하는 컴포넌트
    private final UserDetailsService userDetailsService; // 사용자 정보를 로드하는 서비스


    // JWT 토큰에서 사용자 정보를 추출하여 Authentication 객체를 생성하는 메서드
    private Authentication getAuthentication(String token) {
        String username = jwtProcessor.getUsername(token); // 토큰에서 사용자 이름 추출
        UserDetails principal = userDetailsService.loadUserByUsername(username); // 사용자 이름을 이용해 사용자 상세 정보(UserDetails) 로드
        return new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities()); // 사용자 정보와 권한을 기반으로 Authentication 객체 생성
    }

    // 필터가 실행될 때 호출되는 메서드 (요청당 한 번 실행
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String bearerToken = request.getHeader(AUTHORIZATION_HEADER); // 요청 헤더에서 Authorization 값을 가져옴

        if (bearerToken != null && bearerToken.startsWith(BEARER_PREFIX)) {
            // Bearer 접두사를 제외한 실제 토큰 값을 추출
            String token = bearerToken.substring(BEARER_PREFIX.length());

            // 토큰에서 사용자 정보 추출 및 Authentication 객체 구성 후 SecurityContext 에 저장, 인증 상태 유지
            Authentication authentication = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        super.doFilter(request, response, filterChain); // 다음 필터로 요청을 전달
    }
}
