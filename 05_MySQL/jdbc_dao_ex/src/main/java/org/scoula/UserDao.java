package org.scoula;

import java.sql.*;

// user_ex 데이터 베이스와의 통신을 담당
// 직접 문자열 형태로 DB 서버 접속 정보를 Driver 에 전달하는 형식으로 접속
public class UserDao {
    // 접속 정보를 저장하는 Connection 객체
    static Connection conn = null;

    static {
        // DB 서버 접속 시에는 어떤 예외가 발생할지 모르므로 예외 처리
        try {
            // 데이터베이스 연결 정보를 문자열로 작성한 버전
            // DB 접속에 필요한 Driver 클래스를 지정하는 문자열
            String driver = "com.mysql.cj.jdbc.Driver";
            // DB 에서 어떤 데이터베이스에 접속할지 정하는 문자열, 우리는 user_ex 선택
            String url = "jdbc:mysql://localhost:3306/user_ex";
            // 접속 계정은 root 을 사용하므로 id 는 root 로 설정, 비번은 각자의 비번에 맞게 입력
            String id = "root";
            String password = "0420";

            Class.forName(driver); // JDBC 드라이버 로드
            // 문자열로 지정한 정보를 바탕으로 서버에 접속을 시도
            // 데이터베이스 연결 설정, DriverManager.getConnection 메서드를 사용하여 데이터베이스에 연결하고, Connection 객체를 생성
            conn = DriverManager.getConnection(url, id, password);
            System.out.println("DB 접속에 성공!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 회원 추가
    public void create(String email, String password) {
        String sql = "INSERT INTO users (email, password) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("회원 추가 성공!!!!");
            } else {
                System.out.println("회원 추가 실패!!!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 추가/수정/삭제된 회원을 포함한 전체 회원 조회
    public void getAllUsers() {
        String sql = "SELECT * FROM users";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                UserVo user = new UserVo(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 회원 정보 수정
    public void updateUser(int id, String newEmail, String newPassword) {
        String sql = "UPDATE users SET email = ?, password = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newEmail);
            ps.setString(2, newPassword);
            ps.setInt(3, id);
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("회원 정보 수정 성공!");
            } else {
                System.out.println("회원 정보 수정 실패!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 회원 삭제
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("회원 삭제 성공!!");
            } else {
                System.out.println("회원 삭제 실패...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 이름이 출력되는 회원 조회 (JOIN 사용)
    public void getAllUsersWithName() {
        String sql = "SELECT u.id, u.email, u.password, ui.name " +
                "FROM users u " +
                "INNER JOIN user_info ui ON u.id = ui.id";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String name = rs.getString("name");

                System.out.println("ID: " + id + ", Email: " + email + ", Password: " + password + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
