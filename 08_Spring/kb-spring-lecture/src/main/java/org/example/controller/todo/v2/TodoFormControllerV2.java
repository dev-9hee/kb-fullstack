package org.example.controller.todo.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class TodoFormControllerV2 {
    @GetMapping("/todo/v2/form")
    public String todoForm(HttpServletRequest request, HttpServletResponse response) {
        log.info("================> Todo 추가 페이지 호출, /todo/form");

        return "todo-form2";
    }
}
