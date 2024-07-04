package org.scoula.todo.dao;

import org.scoula.todo.domain.Todo;

import java.util.List;

public interface TodoDao {
    List<Todo> getList();

    Todo getTodo(int id);

    void add(Todo todo);

    void update(Todo todo);

    void delete(int id);
}
