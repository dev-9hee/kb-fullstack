package org.scoula.frontcontroller;

import org.scoula.frontcontroller.command.Command;
import org.scoula.frontcontroller.controller.HomeController;
import org.scoula.frontcontroller.controller.TodoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// @WebServlet 어노테이션 붙이지 않음
public class DispatcherServlet extends HttpServlet {
    // command 와 매핑, 요청별로 매핑을 가짐, url, command
    Map<String, Command> getMap; // GET 요청
    Map<String, Command> postMap; // POST 요청

    String prefix = "/WEB-INF/views/";
    String suffix = ".jsp";

    @Override
    public void init() throws ServletException {
        getMap = new HashMap<>();
        postMap = new HashMap<>();

        createMap(getMap, postMap);
    }

    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {

    }

    private String getCommandName(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        return requestURI.substring(contextPath.length()); // context 부분을 제외한 나머지 부분
    }

    private Command getCommand(HttpServletRequest request) {
        String commandName = getCommandName(request);

        Command command;
        if (request.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
        } else {
            command = postMap.get(commandName);
        }

        return command;
    }

    public void execute(Command command, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String viewName = command.execute(request, response);
        if (viewName.startsWith("redirect:")) { // redirect 처리
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else { // forward 처리
            String view = prefix + viewName + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = getCommand(request);
        if (command != null) {
            execute(command, request, response);
        } else { // 404 에러 처리
            String view = prefix + "404" + suffix;
            RequestDispatcher dis = request.getRequestDispatcher(view);
            dis.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}