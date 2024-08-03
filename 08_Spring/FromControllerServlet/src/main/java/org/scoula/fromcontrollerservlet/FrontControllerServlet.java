package org.scoula.fromcontrollerservlet;

import org.scoula.fromcontrollerservlet.controller.AboutController;
import org.scoula.fromcontrollerservlet.controller.Controller;
import org.scoula.fromcontrollerservlet.controller.HomeController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

// 모든 주소 값이 해당 서블릿을 지나가야 하므로
// 기본 주소 '/' 매핑
@WebServlet(name = "FrontControllerServlet", value = "/")
public class FrontControllerServlet extends HttpServlet {
    private Map<String, Controller> controllers = new HashMap<>();

    @Override
    public void init() throws ServletException {
        // 주소값과 컨트롤러 매핑
        controllers.put("/", new HomeController());
        controllers.put("/about", new AboutController());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    // 교통 경찰관 역할
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI(); // URI : 주소에서 어디까지가 나타남, 풀 주소값이라고 생각하면 됨
        System.out.println("requestURI = " + requestURI);
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);

        String path = requestURI.substring(contextPath.length());
        System.out.println("path = " + path);

        Controller controller = controllers.get(path);

        // 등록된 서비스인지 확인, 해당 컨트롤러에 있는 jsp 파일명을 받아와서 파일을 포워딩 함
        if (controller != null) {
            String viewName = controller.getView(request, response);
            String targetView = "/WEB-INF/views/" + viewName + ".jsp";
            request.getRequestDispatcher(targetView).forward(request, response);
        } else {
            String notFoundView = "/WEB-INF/views/404.jsp";
            request.getRequestDispatcher(notFoundView).forward(request, response);
        }
    }
}