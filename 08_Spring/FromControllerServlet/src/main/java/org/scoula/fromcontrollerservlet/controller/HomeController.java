package org.scoula.fromcontrollerservlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController implements Controller {
    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("imgSrc", "https://cdn.poomang.com/auto-generated/talking-potato/images/cover.png?ts=1681444699874");
        return "index";
    }
}
