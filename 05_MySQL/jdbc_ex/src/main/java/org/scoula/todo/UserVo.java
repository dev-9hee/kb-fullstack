package org.scoula.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class UserVo { // 사용자 정보를 관리
    private final String UserId;
    private final String name;
    private final String password;
    private final Timestamp created_at;
}
