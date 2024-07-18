package org.scoula.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {
    private int page; // 요청 페이지
    private int size; // 한 페이지 당 데이터 건수

    public static PageRequest of(int page, int size) {
        return new PageRequest(page, size);
    }

    public int getOffset() { // offset 값 계산
        return (page - 1) * size;
    }
}
