package org.scoula.frontcontroller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TodoController {

    public String getList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> list = Arrays.asList("Todo 1", "Todo 2", "Todo3");
        request.setAttribute("todoList", list);
        System.out.println("GET /todo/list");
        return "todo/list";
    }

    public String getView(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET /todo/view");
        return "todo/view";
    }

    public String getCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET /todo/create");
        return "todo/create";
    }

    public String postCreate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("POST /todo/create");
        return "redirect:/todo/list";
    }

    public String getUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("GET /todo/update");
        return "todo/update";
    }

    public String postUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("POST /todo/update");
        return "redirect:/todo/list";
    }

    public String postDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("POST /todo/delete");
        return "redirect:/todo/list";
    }
}
