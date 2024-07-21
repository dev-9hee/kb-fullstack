package org.scoula.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

// 회원 정보를 관리하기 위한 VO(Value Object)
// 회원 데이터 베이스의 정보를 객체에 담기 위해, 회원 데이터 베이스의 각각의 컬럼의 값을
// 클래스의 멤버 변수에 매칭 시켜서 관리한다
@Data
@AllArgsConstructor
public class UserVo { // 사용자 정보를 관리
    private final String UserId;
    private final String name;
    private final String password;
    private final Timestamp created_at;
}
