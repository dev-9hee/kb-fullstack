package org.scoula.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 이 클래스는 사용자의 정보를 담기 위한 데이터 전송 객체(DTO)로 사용
@Data // Lombok 이 자동으로 getter, setter, toString, equals, hashCode 메서드를 생성
@NoArgsConstructor // Lombok 애노테이션으로, 매개변수가 없는 기본 생성자를 생성
@AllArgsConstructor // Lombok 애노테이션으로, 모든 필드를 매개변수로 가지는 생성자를 생성
public class UserVO {
    private String id;
    private String password;
    private String name;
    private String role;
}
