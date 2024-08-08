package org.example.controller.todo.v1;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.todo.TodoDtoListV1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class TodoShowControllerV1 {
    private TodoDtoListV1 todoDtoList = TodoDtoListV1.getInstance();

    @GetMapping("/todo/show")
    public String todoShow(HttpServletRequest request, HttpServletResponse response) {
        log.info("================> TODO 리스트 보기 페이지 호출, /todo/show");

        request.setAttribute("todoList", todoDtoList.getList());
        return "todo-show";
    }
}
