import org.junit.jupiter.api.*;
import org.scoula.common.JDBCUtil;

import java.sql.*;

// 테스트 메서드들이 @Order 애노테이션에 정의된 순서대로 실행되도록 함
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// 데이터베이스의 users 테이블에 대해 CRUD(생성, 읽기, 수정, 삭제) 작업을 수행
public class CrudTest {
    // JDBCUtil 유틸리티 클래스를 사용하여 데이터베이스에 연결을 설정
    Connection conn = JDBCUtil.getConnection();

    // 현재 클래스의 모든 테스트 메서드가 실행된 후에 이 메서드가 실행되어야 함을 나타냄
    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    } // 데이터베이스 연결을 닫는 역할

    @Test // 테스트 메서드로 표시
    @DisplayName("새로운 user를 등록한다.") // 테스트의 목적을 설명
    @Order(1) // 이 메서드를 첫 번째로 실행하도록 지정
    public void insertUser() throws SQLException {
        // 새로운 사용자를 users 테이블에 삽입하기 위한 SQL 문
        String sql = "insert into users(id, password, name, role) values(?, ?, ?, ?)"; // 겂울 바꾸고 싶은 애들을 ? 로
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) { // 자동으로 닫히게 try 괄호 안에 넣음
            // 파라미터 설정, 각각의 ?에 값을 설정
            pstmt.setString(1, "scoula");
            pstmt.setString(2, "scoula3");
            pstmt.setString(3, "스콜라");
            pstmt.setString(4, "USER");
            int count = pstmt.executeUpdate(); // SQL 문을 실행하고, 삽입된 행의 수를 반환
            Assertions.assertEquals(1, count); // 삽입된 행의 수가 1인지 확인
        }
    }

    @Test
    @DisplayName("user 목록을 추출한다.")
    @Order(2) // 이 메서드를 두 번째로 실행하도록 지정
    public void selectUser() throws SQLException {
        // 모든 사용자를 선택하기 위한 SQL 문
        String sql ="select * from users";
        // SQL 문을 실행하고 결과를 ResultSet 객체로 반환
        try(Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql); // select 문 실행
        ) {
            while(rs.next()) { // 각 행의 name 컬럼 값을 출력
                System.out.println(rs.getString("name"));
            }
        }
    }

    @Test @DisplayName("특정 user 검색한다.")
    @Order(3) // 이 메서드를 세 번째로 실행하도록 지정
    public void selectUserById() throws SQLException
    {
        String userid = "scoula"; // 검색할 사용자 ID를 설정
        // 특정 사용자를 선택하기 위한 SQL 문
        String sql ="select * from users where id = ?";
        try(PreparedStatement stmt = conn.prepareStatement
                (sql)){
            stmt.setString(1, userid); // ?에 사용자 ID 값을 설정
            // 결과를 처리하여 사용자가 존재하면 name 컬럼 값을 출력
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    System.out.println
                            (rs.getString("name"));
                } else { // 존재하지 않으면 예외를 던짐
                    throw new SQLException("scoula not found");
                }
            }
        }
    }

    @Test
    @DisplayName("특정 user 수정한다.")
    @Order(4) // 이 메서드를 네 번째로 실행하도록 지정
    public void updateUser() throws SQLException {
        String userid = "scoula"; // 수정할 사용자 ID를 설정
        // 사용자의 이름을 수정하기 위한 SQL 문
        String sql ="update users set name= ? where id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            // 각각의 ?에 값을 설정
            stmt.setString(1, "스콜라 수정");
            stmt.setString(2, userid);
            int count = stmt.executeUpdate(); // SQL 문을 실행하고, 수정된 행의 수를 반환
            Assertions.assertEquals(1, count); // 수정된 행의 수가 1인지 확인
        }
    }

    @Test
    @DisplayName("지정한 사용자를 삭제한다.")
    @Order(5) // 이 메서드를 다섯 번째로 실행하도록 지정
    public void deleteUser() throws SQLException {
        String userid = "scoula"; // 삭제할 사용자 ID를 설정
        // 사용자를 삭제하기 위한 SQL 문
        String sql ="delete from users where id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, userid); // ?에 사용자 ID 값을 설정
            int count = stmt.executeUpdate(); // SQL 문을 실행하고, 삭제된 행의 수를 반환
            Assertions.assertEquals(1, count); // 삭제된 행의 수가 1인지 확인
        }
    }
}
