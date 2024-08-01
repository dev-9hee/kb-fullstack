package org.scoula.frontcontroller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController { // view 이름 : index; => /views/index.jsp
    public String getIndex(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        return "index";
    }
}
