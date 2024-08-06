package org.example.dto.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoDtoListV1 {
    private static TodoDtoListV1 instance;
    private List<TodoDto> todoDtoList;

    private TodoDtoListV1() {
        todoDtoList = new ArrayList<>();
        this.addTodo("스프링 정복하기");
        this.addTodo("코테 정복하기");
    }

    public static synchronized TodoDtoListV1 getInstance() {
        if (instance == null) {
            instance = new TodoDtoListV1();
        }
        return instance;
    }

    public void addTodo(String todo) {
        todoDtoList.add(new TodoDto(todo));
    }

    public List<TodoDto> getTodoList() {
        return todoDtoList;
    }
}
