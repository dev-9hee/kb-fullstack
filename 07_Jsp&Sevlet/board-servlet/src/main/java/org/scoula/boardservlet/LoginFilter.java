package org.scoula.boardservlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/board")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false); // false 옵션 => 없어도 새로 만들진 마라
        // 접속한 적이 없거나, 로그인 한 적이 없으면
        boolean loggedIn = ( session != null && session.getAttribute("username") != null);

        if (loggedIn) { // 로그인 성공
            chain.doFilter(request, response);
        } else { // 로그인 실패
            httpResponse.sendRedirect("/auth.jsp");
        }
    }
}
