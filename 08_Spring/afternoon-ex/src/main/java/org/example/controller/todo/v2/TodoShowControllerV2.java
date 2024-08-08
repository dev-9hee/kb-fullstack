package org.example.controller.todo.v2;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.todo.TodoDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class TodoShowControllerV2 {
    private TodoDtoListV2 todoList;

    @Autowired
    public TodoShowControllerV2(TodoDtoListV2 todoDtoList) {
        this.todoList = todoDtoList;
    }

    @RequestMapping(value = "/todo/v2/show", method = RequestMethod.GET)
    public String showTodo(Model model) {
        log.info("=============> Todo 목록 보기, /todo/v2/show");

        model.addAttribute("todoList", todoList.getTodoList());
        return "todo-show2";
    }
}
