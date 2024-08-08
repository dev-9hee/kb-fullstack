package org.example.controller.todo.v1;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.todo.TodoDtoListV1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class TodoSaveControllerV1 {
    private TodoDtoListV1 todoDtoListV1 = TodoDtoListV1.getInstance();

    @RequestMapping(value = "/todo/form/save", method = RequestMethod.GET)
    public String todoSave(HttpServletRequest request, HttpServletResponse response) {
        log.info("================> 회원 추가 Request 호출, /member/form/save");

        String todo = request.getParameter("todo");
        todoDtoListV1.addList(todo);

        request.setAttribute("todoList", todoDtoListV1.getList());
        return "todo-show";
    }
}
