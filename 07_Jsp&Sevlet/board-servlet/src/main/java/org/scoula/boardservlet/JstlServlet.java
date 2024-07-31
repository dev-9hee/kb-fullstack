package org.scoula.boardservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jstl")
public class JstlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> list = new ArrayList<>();
        list.add("아이템1");
        list.add("아이템2");
        list.add("아이템3");

        request.setAttribute("list", list); // list 라는 이름으로 위 리스트를 넘겨줌
        request.setAttribute("condition", true);

        boolean isJSTL = "true".equals(request.getParameter("jstl")) ? true : false;

        if (isJSTL) {
            // jstl 사용
            request.getRequestDispatcher("jstl.jsp").forward(request, response);
        } else {
            // 일반 스크립틀렛으로 구현
            request.getRequestDispatcher("scriptlet.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}