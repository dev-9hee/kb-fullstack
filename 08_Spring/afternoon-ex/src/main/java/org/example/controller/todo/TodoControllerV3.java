package org.example.controller.todo;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.todo.TodoDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
@RequestMapping("/todo/v3")
public class TodoControllerV3 {
    private TodoDtoListV2 todoList;

    @Autowired
    public TodoControllerV3(TodoDtoListV2 todoDtoList) {
        this.todoList = todoDtoList;
    }

    @GetMapping("/show")
    public String showTodo(Model model) {
        log.info("=============> Todo 목록 보기, /todo/v3/show");

        model.addAttribute("todoList", todoList.getTodoList());
        return "todo-show3";
    }

    @GetMapping("/form")
    public String formTodo() {
        log.info("================> Todo 추가 페이지, /todo/v3/form");
        return "todo-form3";
    }

    @GetMapping("/form/save")
    public String formSave(
            @RequestParam("todo") String todo,
            Model model) {
        log.info("==========> Todo 추가 Request 호출, /todo/v3/form/save");

        todoList.addTodo(todo);

        model.addAttribute("todoList", todoList.getTodoList());
        return "todo-show3";
    }
}
