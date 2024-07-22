package org.scoula;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    // user_ex2 데이터 베이스에 접속
    static Connection conn = null;

    static {
        try {
            String Driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/user_ex2";
            String user = "root";
            String password = "0420";

            Class.forName(Driver);
            conn = DriverManager.getConnection(url, user, password);

            System.out.println("DB 접속에 성공!");
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

            int affectRows = ps.executeUpdate();

            if (affectRows > 0) {
                System.out.println("회원 추가 성공!!");
            } else {
                System.out.println("회원 추가 실패!!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 추가 회원 조회
    public void getAllUsers() {
        List<UserVo> userList = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");

                UserVo user = new UserVo(id, email, password);
                userList.add(user);
            }
            userList.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 회원 수정
    public void updateUser(int id, String newEmail, String newPassword) {
        String sql = "UPDATE users SET email = ?, password = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newEmail);
            ps.setString(2, newPassword);
            ps.setInt(3, id);

            int affectRows = ps.executeUpdate();
            if (affectRows > 0) {
                System.out.println("회원 정보 수정 성공!");
            } else {
                System.out.println("회원 정보 수정 실패");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 회원 삭제
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            int affectRows = ps.executeUpdate();

            if (affectRows > 0) {
                System.out.println("회원 삭제 성공!");
            } else {
                System.out.println("회원 삭제 실패!!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 회원 이름까지 표시된 목록 출력 (JOIN 사용)
    public void getAllUsersWithName() {
        String sql = "SELECT u.id, u.email, u.password, ui.name " +
                "FROM users u INNER JOIN user_info ui " +
                "ON u.id = ui.id";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String name = rs.getString("name");

                System.out.printf("ID: %d, Email: %s, Password: %s, Name: %s\n", id, email, password, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
