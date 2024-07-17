package org.scoula.todo.dao;

import org.scoula.todo.domain.TodoV0;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// 인터페이스 정의, 사용자 ID를 인자로 항상 전달
public interface TodoDao {
    // 총 데이터 건수
    int getTotalCount(String userId) throws SQLException;

    // Todo 등록
    int create(TodoV0 todo) throws SQLException;

    // Todo 목록 조회
    List<TodoV0> getList(String userId) throws SQLException;

    // Todo 정보 조회
    Optional<TodoV0> get(String userId, Long id) throws SQLException;

    // 검색
    List<TodoV0> search(String userId, String keyword) throws SQLException;

    // Todo 수정
    int update(String userId, TodoV0 todo) throws SQLException;

    // Todo 삭제
    int delete(String userId, Long id) throws SQLException;
}
