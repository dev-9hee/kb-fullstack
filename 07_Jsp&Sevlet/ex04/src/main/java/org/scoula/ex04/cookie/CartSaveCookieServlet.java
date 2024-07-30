package org.scoula.ex04.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cart_save_cookie")
public class CartSaveCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        // 입력 파라미터 얻기
        String product = request.getParameter("product");

        // 기존 쿠키 얻기
        Cookie [] cookies = request.getCookies();
        Cookie c = null;
        if(cookies == null || cookies.length == 0) {
            c = new Cookie("product", product);
        } else {
            c = new Cookie("product" + ( cookies.length+1 ), product);
        }

        // 쿠기를 응답처리
        response.addCookie(c);

        out.print("<html><body>");
        out.print("Product 추가!!<br>");
        out.print("<a href='cookie_product.jsp'>상품 선택 페이지</a><br>");
        out.print("<a href='cart_view_cookie'>장바구니 보기</a>");
        out.print("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}