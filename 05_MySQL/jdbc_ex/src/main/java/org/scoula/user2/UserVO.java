package org.scoula.user2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data // 자동으로 Getter/Setter, equals, hashCode 메서드 생성
@AllArgsConstructor // 모든 필드르 포함한 생성자 생성
public class UserVO {
    // 객체의 필드를 전부 불변으로 설정
    private final int id;
    private final String userid;
    private final String name;
    private final String password;
    private final int age;
    private final boolean membership;
    private final Timestamp signupDate;
}
