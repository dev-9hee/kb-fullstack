package org.example.security;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationInterceptor implements HandlerInterceptor {

    // request 들어오기 전에, 로그인 하기 전에 => preHandler
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        System.out.println("요청 URI : " + requestUri); // 클라이언트의 요청이 어디로 오는지 확인하는 코드

        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") == null) { // 로그인이 되면 loginUser 라는 프로퍼티 값에 넣어줌
            System.out.println("로그인 안됨. 리다이렉트 중: /user/login");
            response.sendRedirect("/user/login"); // 로그인으로 가세요~~~
            return false; // 실패
        }
        return true; // 성공
    }
}
