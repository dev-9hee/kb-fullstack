package org.scoula.user2;

import org.scoula.common.JDBCUtil;
import org.scoula.user.User;

import java.sql.*;
import java.util.ArrayList;

// DAO 만 DB 에 접근하도록 함, DB 통신
public class UserDAO {
    // 접속 정보를 인스턴스가 멤버로 가지고 있도록
    private final Connection conn;

    public UserDAO() {
        this.conn = JDBCUtil.getConnection();
    }

    // 사용자 추가
    public void addUser(UserVO newUser) {
        // 매번 새로운 회원 데이터를 추가해야 하므로 변경되는 쿼리를 편리하게 작성하기 위한 PreparedStatement 설정
        String sql = "INSERT INTO user_table (userid, name, password, age, membership) VALUES(?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 생성된 User 객체로부터 각각의 정보를 가져와서 PreparedStatement 에 삽입
            pstmt.setString(1, newUser.getUserid());
            pstmt.setString(2, newUser.getName());
            pstmt.setString(3, newUser.getPassword());
            pstmt.setInt(4, newUser.getAge());
            pstmt.setBoolean(5, newUser.isMembership());
            pstmt.executeUpdate();

            System.out.println("회원 추가 성공!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 모든 회원 조회
    public void getAllUsers() {
        String sql = "SELECT * FROM user_table";

        // Try-with-resources 를 사용하여 DB 접속 후 접속 종료를 자동으로 수행
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) { // select 쿼리의 결과를 담는 ResultSet 을 이용하여 쿼리의 실행 결과문 담기
            // select 쿼리가 가져다 준 여러 개의 데이터를 테이블 형태의 set 으로 담는 데이터 구조
            ArrayList<UserVO> users = new ArrayList<>(); // 데이터 추가가 용이한 ArrayList 컬렉션 사용
            while (rs.next()) { // rs.next() : 다음 데이터가 있는지 여부 확인, 있으면 true, 없으면 false
                int id = rs.getInt("id");
                String userid = rs.getString("userid");
                String name = rs.getString("name");
                String password = rs.getString("password");
                int age = rs.getInt("age");
                boolean membership = rs.getBoolean("membership");
                Timestamp signup_date = rs.getTimestamp("signup_date");

                UserVO user = new UserVO(id, userid, name, password, age, membership, signup_date);

                users.add(user);
            }

            // 리스트에 있는 각 user 객체에 대해 System.out.println(user)를 실행
            // forEach() : 리스트의 각 요소에 대해 지정된 동작을 수행
            users.forEach((user) -> System.out.println(user)); // 기본적으로 user.toString() 메서드를 호출하여 그 반환값을 출력
            // users.forEach(System.out::println); // 위와 같은 코드
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
