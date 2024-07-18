package org.scoula.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class TodoVo { // TodoList 정보를 관리
    private final int id;
    private final String user_id;
    private final String todo;
    private final Boolean is_completed;
    private final Timestamp created_at;
}
