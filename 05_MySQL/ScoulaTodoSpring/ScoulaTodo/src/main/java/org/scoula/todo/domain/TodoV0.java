package org.scoula.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoV0 { // Todo 테이블에 대한 모델 객체, 빌더 패턴 적용
    private Long id;
    private String title;
    private String description;
    private Boolean done;
    private String userId;
}
