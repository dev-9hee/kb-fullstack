package org.scoula.boardservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/board";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "0420";
    private static Connection conn = null;

    @Override
    public void init() throws ServletException {
        System.out.println("##### LoginServlet init 메서드 호출 #####");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            System.out.println("##### MySQL 연결 성공 #####");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // /login 주소로 요청이 오면 로그인 페이지 파일을 제공
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isLoginSuccess = false;

        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        isLoginSuccess = true;

                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isLoginSuccess) { // 로그인 성공
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect("/board"); // 게시판 페이지로 이동
        } else {
            response.sendRedirect("loginFailed.jsp");
        }
    }

    @Override
    public void destroy() {
        try {
            conn.close();
            System.out.println("##### MySQL 접속 종료 #####");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("##### LoginServlet destroy 메서드 호출 #####");
    }
}