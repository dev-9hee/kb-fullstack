package org.scoula.todo.dao;

import org.scoula.todo.domain.Todo;

import java.util.ArrayList;
import java.util.List;

// Data Access Object, 데이터에 대한 CRUD 처리 담당
// 데이터 소스(배열, List, 데이터베이스 등)에 대한 처리를 상위 계층(비즈니스 계층)으로 부터 분리
public class TodoDao {
    // 기본적으로 싱글톤 패턴
    private static TodoDao instance = new TodoDao();

    public static TodoDao getInstance() {
        return instance;
    }

    private List<Todo> list;

    private TodoDao() {
        list = new ArrayList<>();
        for(int i = 0; i < 10; i++) { // 임시 테스트 데이터 구성
            Todo todo = Todo.builder()
                    .title("Todo " + i)
                    .description("Description " + i)
                    .done(false)
                    .build();
            list.add(todo);
        }
    }

    public List<Todo> getList() {
        return list;
    }

    public Todo getTodo(int id) {
        for(Todo todo : list) {
            if(todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public void add(Todo todo) {
        list.add(todo);
    }

    public void update(Todo todo) {
        for(int i = 0; i < list.size(); i++) {
            if(todo.getId() == list.get(i).getId()) {
                list.set(i, todo);
            }
        }
    }

    public void delete(int id) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id) {
                list.remove(i);
                return;
            }
        }
    }
}
