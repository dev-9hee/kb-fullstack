package org.scoula.todo.dao;

import org.scoula.todo.domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

// 인터페이스 정의
// 데이터베이스의 users 테이블에 대한 CRUD(생성, 읽기, 수정, 삭제) 작업을 추상화
// 각 메서드는 예외 처리를 위해 SQLException 을 던질 수 있음!
public interface UserDao {
    // 회원 등록, 새로운 사용자를 데이터베이스에 등록, 등록할 사용자 정보를 담고 있는 UserVO 객체
    int create(UserVO user) throws SQLException;

    // 회원 목록 조회, 데이터베이스에서 모든 사용자 정보를 조회
    // 조회된 사용자 정보를 담고 있는 UserVO 객체들의 리스트를 반환
    List<UserVO> getList() throws SQLException;

    // 회원 정보 조회, 주어진 ID를 가진 사용자의 정보를 조회
    // 주어진 ID를 가진 사용자가 존재할 경우 그 사용자 정보를 담고 있는 UserVO 객체를 반환
    // 사용자가 존재하지 않을 경우 Optional.empty()를 반환
    Optional<UserVO> get(String id) throws SQLException;

    // 회원 수정, 주어진 사용자 정보를 사용하여 데이터베이스의 사용자 정보를 수정
    // 성공적으로 수정된 레코드의 수를 반환
    int update(UserVO user) throws SQLException;

    // 회원 삭제, 주어진 ID를 가진 사용자를 데이터베이스에서 삭제
    // 성공적으로 삭제된 레코드의 수를 반환
    int delete(String id) throws SQLException;
}
