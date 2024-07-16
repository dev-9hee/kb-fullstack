package org.scoula.dao;

import org.junit.jupiter.api.*;
import org.scoula.common.JDBCUtil;
import org.scoula.domain.UserVO;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

// UserDaoImpl 클래스의 CRUD 작업을 테스트하는 UserDaoTest 클래스
// 테스트 메서드들은 데이터베이스의 users 테이블에 대해 삽입, 조회, 수정, 삭제 작업을 수행
// 각 테스트는 특정 순서대로 실행
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDaoTest {
    UserDao dao = new UserDaoImpl(); // 테스트 대상인 UserDaoImpl 인스턴스를 생성

    @AfterAll // 모든 테스트 메서드가 실행된 후 호출
    static void tearDown() {
        JDBCUtil.close(); // 데이터베이스 연결 종료
    }

    @Test
    @DisplayName("user 를 등록합니다.")
    @Order(1)
    void create() throws SQLException {
        UserVO user = new UserVO("ssamz3", "ssamz123", "쌤즈", "ADMIN");
        int count = dao.create(user); // 새로운 UserVO 객체를 생성하고 create 메서드를 호출하여 데이터를 삽입
        Assertions.assertEquals(1, count); // 삽입된 레코드 수가 1인지 확인
    }

    @Test
    @DisplayName("UserDao User 목록을 추출합니다.")
    @Order(2)
    void getList() throws SQLException {
        List<UserVO> list = dao.getList(); // 메서드를 호출하여 모든 사용자 정보를 조회
        for (UserVO vo : list) {
            System.out.println(vo); // 조회된 사용자 정보를 출력
        }
    }

    @Test
    @DisplayName("특정 user 1건을 추출합니다.")
    @Order(3)
    void get() throws SQLException {
        // // dao.get("ssamz3") 메서드를 호출하여 특정 사용자를 조회
        UserVO user = dao.get("ssamz3").orElseThrow(NoSuchElementException::new);
        Assertions.assertNotNull(user); // 조회된 사용자가 존재하는지 확인
    }

    @Test
    @DisplayName("user 의 정보를 수정합니다.")
    @Order(4)
    void update() throws SQLException {
        // 서드를 호출하여 특정 사용자를 조회
        UserVO user = dao.get("ssamz3").orElseThrow(NoSuchElementException::new);
        // 조회된 사용자의 이름을 변경하고 update 메서드를 호출하여 데이터를 수정
        user.setName("쌤즈3");
        int count = dao.update(user);
        Assertions.assertEquals(1, count); // 수정된 레코드 수가 1인지 확인
    }

    @Test
    @DisplayName("user 를 삭제합니다.")
    @Order(5)
    void delete() throws SQLException {
        int count = dao.delete("ssamz3"); // 특정 사용자를 삭제
        Assertions.assertEquals(1, count); // 삭제된 레코드 수가 1인지 확인
    }
}