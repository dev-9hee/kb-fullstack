package org.scoula.fromcontrollerservlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 컨트롤러
public class AboutController implements Controller {
    @Override
    public String getView(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("msg", "컨트롤러가 전달한 메시지 입니다!");
        request.setAttribute("imgSrc", "https://item.kakaocdn.net/do/96fc93fd7bec631ff693625f6b89bb8082f3bd8c9735553d03f6f982e10ebe70");
        return "about";
    }
}
