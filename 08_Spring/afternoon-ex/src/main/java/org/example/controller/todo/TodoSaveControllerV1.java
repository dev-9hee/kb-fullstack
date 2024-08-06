package org.example.controller.todo;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.todo.TodoDtoListV1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class TodoSaveControllerV1 {
    private TodoDtoListV1 todoList = TodoDtoListV1.getInstance();

    @RequestMapping(value = "todo/form/save", method = RequestMethod.GET)
    public String addSave(HttpServletRequest request) {
        log.info("==========> Todo 추가 Request 호출, /todo/form/save");

        String todo = request.getParameter("todo");

        todoList.addTodo(todo);

        request.setAttribute("todoList", todoList.getTodoList());
        return "todo-show";
    }

}
