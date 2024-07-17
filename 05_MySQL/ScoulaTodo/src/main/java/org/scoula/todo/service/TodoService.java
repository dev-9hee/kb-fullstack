package org.scoula.todo.service;

import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.context.Context;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.dao.TodoDaoImpl;
import org.scoula.todo.domain.TodoV0;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class TodoService {
    TodoDao dao = new TodoDaoImpl(); // 결합도가 낮고 응집도가 높아야 좋은건데, 결합도가 높으므로 안 좋은 코드

    Supplier<String> userId = () -> Context.getContext().getUser().getId();

    // 목록 보기
    public void print() {
        try {
            int count = dao.getTotalCount(userId.get());
            System.out.println("####" + userId.get());
            List<TodoV0> list = dao.getList(userId.get());

            System.out.println("총 건수 : " + count);
            System.out.println("====================================");
            for (TodoV0 todo : list) {
                // 형식 지정자는 정수를 3자리로 출력하며, 필요 시 앞에 0을 채웁
                System.out.printf("%03d] %s%s\n", todo.getId(), todo.getTitle(),
                        todo.getDone() ? "(완료)" : "");
            }
            System.out.println("====================================");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 검색
    public void search() {
        String keyword = Input.getLine("검색어: ");
        keyword = "%" + keyword + "%";
        try {
            List<TodoV0> list = dao.search(userId.get(), keyword);
            System.out.println("총 건수: " + list.size());

            System.out.println("====================================");
            for (TodoV0 todo : list) {
                System.out.printf("%03d] %s%s\n", todo.getId(), todo.getTitle(),
                        todo.getDone() ? "(완료)" : "");
            }
            System.out.println("====================================");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 상세보기
    public void detail() {
        long id = (long)Input.getInt("Todo ID : ");
        try {
            TodoV0 todo = dao.get(userId.get(), id).orElseThrow(NoSuchElementException::new);
            System.out.println("====================================");
            System.out.printf("Todo ID : %s\n", todo.getId());
            System.out.printf("제목 : %s\n", todo.getTitle());
            System.out.printf("설명 : %s\n", todo.getDescription());
            System.out.printf("완료여부 : %s\n", todo.getDone() ? "완료" : "미완료");
            System.out.println("====================================");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 추가
    public void create() {
        String title = Input.getLine("제목 : ");
        String description = Input.getLine("설명 : ");
        TodoV0 todo = TodoV0.builder()
                .title(title)
                .description(description)
                .userId(userId.get())
                .done(false)
                .build();
        try {
            dao.create(todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 수정
    public void update() {
        Long id = (long)Input.getInt("수정할 Todo ID : ");
        try {
            TodoV0 todo = dao.get(userId.get(), id).orElseThrow(NoSuchElementException::new);
            System.out.println("====================================");
            String title = Input.getLine("제목", todo.getTitle());
            String description = Input.getLine("설명", todo.getDescription());
            boolean done = Input.confirm("완료", todo.getDone());
            System.out.println("====================================");

            todo.setTitle(title);
            todo.setDescription(description);
            todo.setDone(done);

            dao.update(userId.get(), todo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 삭제
    public void delete() {
        Long id = (long)Input.getInt("삭제할 Todo ID : ");
        boolean answer = Input.confirm("삭제할까요?");
        if (answer) {
            try {
                dao.delete(userId.get(), id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
