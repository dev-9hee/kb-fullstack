package org.scoula.boardservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/setCookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 쿠키 생성
        Cookie userCookie = new Cookie("username", "jihee");
        // 쿠키의 유효 기간을 설정, 초 단위로 들어감
        userCookie.setMaxAge(7); // 7초, 하루 (60 * 60 * 24)

        // 응답에 쿠키 추가
        response.addCookie(userCookie);

        // 응답 내용 작성
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>쿠키가 생성 되었습니다!</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}