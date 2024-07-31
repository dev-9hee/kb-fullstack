package org.scoula.boardservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet("/ex2")
public class Ex2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random rand = new Random();
        Boolean isRand = rand.nextBoolean();
        request.setAttribute("condition", isRand);
        request.setAttribute("msg1", "럭키비키!");
        request.setAttribute("msg2", "내일은 럭키비키!");

        List<String> list = new ArrayList<>();
        list.add("김치찜");
        list.add("초밥");
        list.add("냉삼");
        request.setAttribute("lunchList", list);

        request.getRequestDispatcher("ex2.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}