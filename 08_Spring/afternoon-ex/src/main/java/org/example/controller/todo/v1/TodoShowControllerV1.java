package org.example.controller.todo.v1;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.todo.TodoDtoListV1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class TodoShowControllerV1 {
    private TodoDtoListV1 todoList = TodoDtoListV1.getInstance();

    @RequestMapping(value = "/todo/show", method = RequestMethod.GET)
    public String showTodo(HttpServletRequest request) {
        log.info("=============> Todo 목록 보기, /todo/show");

        request.setAttribute("todoList", todoList.getTodoList());
        return "todo-show";
    }
}
