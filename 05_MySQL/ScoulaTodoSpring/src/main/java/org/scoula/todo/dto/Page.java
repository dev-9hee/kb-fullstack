package org.scoula.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.todo.domain.TodoV0;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private int totalCount; // 전체 데이터 건수
    private int totalPage; // 전체 페이지 수
    private int page; // 현재 페이지
    private int pageSize; // 한 페이지 당 데이터 건수
    private List<TodoV0> list; // 데이터 목록

    public static Page of(PageRequest request, int totalCount, List<TodoV0> list) {
        int totalPage = (int)Math.ceil((double)totalCount/ request.getSize()); // 전체 페이지 수 계산
        int page = request.getPage();
        int pageSize = request.getSize();

        return new Page(totalCount, totalPage, page, pageSize, list);
    }
}
