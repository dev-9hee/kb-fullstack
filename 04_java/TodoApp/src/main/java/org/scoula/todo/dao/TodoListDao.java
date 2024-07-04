package org.scoula.todo.dao;

import org.scoula.todo.domain.Todo;

import java.util.ArrayList;
import java.util.List;

// Data Access Object, 데이터에 대한 CRUD 처리 담당
// 데이터 소스(배열, List, 데이터베이스 등)에 대한 처리를 상위 계층(비즈니스 계층)으로 부터 분리
public class TodoListDao implements TodoDao {
    // 기본적으로 싱글톤 패턴
    private static TodoListDao instance = new TodoListDao();

    public static TodoDao getInstance() {
        return instance;
    }

    private List<Todo> list;

    private TodoListDao() {
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

    @Override
    public List<Todo> getList() {
        return list;
    }

    @Override
    public Todo getTodo(int id) {
        for(Todo todo : list) { // 코드 중복
            if(todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    @Override
    public void add(Todo todo) {
        list.add(todo);
    }

    @Override
    public void update(Todo todo) {
        for(int i = 0; i < list.size(); i++) { // 코드 중복
            if(todo.getId() == list.get(i).getId()) {
                list.set(i, todo);
            }
        }
    }

    @Override
    public void delete(int id) {
        for(int i = 0; i < list.size(); i++) { // 코드 중복
            if(list.get(i).getId() == id) {
                list.remove(i);
                return;
            }
        }
    }
}
