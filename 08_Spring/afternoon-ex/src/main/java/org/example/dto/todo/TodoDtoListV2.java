package org.example.dto.todo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoDtoListV2 {
    private List<TodoDto> todoDtoList;

    private TodoDtoListV2() {
        todoDtoList = new ArrayList<>();
        this.addTodo("스프링 정복하기");
        this.addTodo("코테 정복하기");
    }

    public void addTodo(String todo) {
        todoDtoList.add(new TodoDto(todo));
    }

    public List<TodoDto> getTodoList() {
        return todoDtoList;
    }
}
