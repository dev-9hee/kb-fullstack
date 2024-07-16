package org.scoula.user;

import org.scoula.common.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

// DB 통신 담당
public class ManageUser {
    // 로그인
    public User loginUser(String userid, String password) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "SELECT * FROM user_table WHERE userid = ? AND password = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userid);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    return new User (
                            rs.getInt("id"),
                            rs.getString("userid"),
                            rs.getString("name"),
                            rs.getString("password"),
                            rs.getInt("age"),
                            rs.getBoolean("membership"),
                            rs.getTimestamp("signup_date")
                    );
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    // 로그아웃
    public void logoutUser() {
        System.out.println("User logged out.");
    }

    // 사용자 추가
    public void addUser(User newUser) {
        Connection conn = JDBCUtil.getConnection();
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

    // 특정 회원 삭제하기 기능 구현
    public void deleteUserById(int id) {
        Connection conn = JDBCUtil.getConnection();
        // 해당 id를 가진 사용자를 삭제하기 위해 sql 문 설정
        String sql = "DELETE FROM user_table WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectRows = pstmt.executeUpdate();
            if (affectRows == 0) {
                System.out.println("ID가 " + id + "인 회원이 존재하지 않습니다.");
            } else {
                System.out.println("ID가 " + id + "인 회원 정보가 성공적으로 제거 되었습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 모든 회원 조회
    public void getAllUsers() {
        Connection conn = JDBCUtil.getConnection();
        String sql = "SELECT * FROM user_table";

        // Try-with-resources 를 사용하여 DB 접속 후 접속 종료를 자동으로 수행
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) { // select 쿼리의 결과를 담는 ResultSet 을 이용하여 쿼리의 실행 결과문 담기
            // select 쿼리가 가져다 준 여러 개의 데이터를 테이블 형태의 set 으로 담는 데이터 구조
            ArrayList<User> users = new ArrayList<>(); // 데이터 추가가 용이한 ArrayList 컬렉션 사용
            while (rs.next()) { // rs.next() : 다음 데이터가 있는지 여부 확인, 있으면 true, 없으면 false
                int id = rs.getInt("id");
                String userid = rs.getString("userid");
                String name = rs.getString("name");
                String password = rs.getString("password");
                int age = rs.getInt("age");
                boolean membership = rs.getBoolean("membership");
                Timestamp signup_date = rs.getTimestamp("signup_date");

                User user = new User(id, userid, name, password, age, membership, signup_date);

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

    // 특정 철자가 들어가는 회원 검색 기능
    public void searchUsersByName(String namePart) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "SELECT * FROM user_table WHERE name LIKE ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + namePart + "%");
            ArrayList<User> users = new ArrayList<>();

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    User user = new User(
                            rs.getInt("id"),
                            rs.getString("userid"),
                            rs.getString("name"),
                            rs.getString("password"),
                            rs.getInt("age"),
                            rs.getBoolean("membership"),
                            rs.getTimestamp("signup_date")
                    );
                    users.add(user);
                }
            }
            if (!users.isEmpty()) {
                users.forEach(System.out::println);
            } else {
                System.out.println("해당 철자가 포함된 회원이 존재하지 않습니다!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 유저 정보 수정 기능 구현
    public void updateUserDetails(int id, String updateName, String updatePassword, int updateAge, boolean updateMembership) {
        Connection conn = JDBCUtil.getConnection();
        String sql = "UPDATE user_table SET name = ?, password = ?, age = ?, membership = ? WHERE id = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, updateName);
            pstmt.setString(2, updatePassword);
            pstmt.setInt(3, updateAge);
            pstmt.setBoolean(4, updateMembership);
            pstmt.setInt(5, id);

            int affectRows = pstmt.executeUpdate();
            if (affectRows > 0) {
                System.out.println("ID가 " + id + "인 회원 정보가 성공적으로 업데이트 되었습니다.");
            } else {
                System.out.println("ID가 " + id + "인 회원이 존재하지 않습니다!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
