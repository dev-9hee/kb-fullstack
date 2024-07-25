package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    // 회원 추가
    public void addUser(UserVo newUser) {
        try {
            // 1. Driver 커넥터 설정
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. 드라이버 설정 OK");

            // 2. DB 연결
            String url = "jdbc:mysql://localhost:3306/user_ex"; // user_ex : 사용하는 데이터베이스명으로 일치
            String id = "root";
            String password = "0420";
            Connection conn = DriverManager.getConnection(url, id, password); // DB 접속
            System.out.println("2. DB 연결 OK");

            // 3. SQL 문 생성
            String sql = "INSERT INTO users (email, password) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newUser.getEmail());
            pstmt.setString(2, newUser.getPassword());
            System.out.println("3. SQL 문 생성 OK");

            // 4. SQL 문 전송 및 실행
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("회원 추가 성공");
            } else {
                System.out.println("회원 추가 실패");
            }

            // 5. 자원 해제
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<UserVo> getAllUsers() {
        List<UserVo> userList = new ArrayList<>();

        try {
            // 1. Driver 커넥터 설정
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. 드라이버 설정 OK");

            // 2. DB 연결
            String url = "jdbc:mysql://localhost:3306/user_ex"; // user_ex : 사용하는 데이터베이스명으로 일치
            String id = "root";
            String password = "0420";
            Connection conn = DriverManager.getConnection(url, id, password); // DB 접속
            System.out.println("2. DB 연결 OK");

            // 3. SQL 문 생성
            String sql = "SELECT * FROM users";
            Statement stmt = conn.createStatement();
            System.out.println("3. SQL 문 생성 OK");

            // 4. SQL 문 전송 및 실행
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int userId = rs.getInt("id");
                String userEmail = rs.getString("email");
                String userPassword = rs.getString("password");

                UserVo user = new UserVo(userId, userEmail, userPassword);
                userList.add(user);
            }

            // 5. 자원 해제
            stmt.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public List<UserVo> getSelectUser(int userid) {
        List<UserVo> userList = new ArrayList<>();

        try {
            // 1. Driver 커넥터 설정
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. 드라이버 설정 OK");

            // 2. DB 연결
            String url = "jdbc:mysql://localhost:3306/user_ex"; // user_ex : 사용하는 데이터베이스명으로 일치
            String id = "root";
            String password = "0420";
            Connection conn = DriverManager.getConnection(url, id, password); // DB 접속
            System.out.println("2. DB 연결 OK");

            // 3. SQL 문 생성
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userid);
            System.out.println("3. SQL 문 생성 OK");

            // 4. SQL 문 전송 및 실행
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("id");
                String userEmail = rs.getString("email");
                String userPassword = rs.getString("password");

                UserVo user = new UserVo(userId, userEmail, userPassword);
                userList.add(user);
            }

            // 5. 자원 해제
            pstmt.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    // 회원 수정
    public void updateUser(UserVo updateUser) {
        try {
            // 1. Driver 커넥터 설정
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. 드라이버 설정 OK");

            // 2. DB 연결
            String url = "jdbc:mysql://localhost:3306/user_ex"; // user_ex : 사용하는 데이터베이스명으로 일치
            String id = "root";
            String password = "0420";
            Connection conn = DriverManager.getConnection(url, id, password); // DB 접속
            System.out.println("2. DB 연결 OK");

            // 3. SQL 문 생성 OK
            String sql = "UPDATE users SET email = ?, password = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, updateUser.getEmail());
            pstmt.setString(2, updateUser.getPassword());
            pstmt.setInt(3, updateUser.getId());
            System.out.println("3. SQL 문 생성 OK");

            // 4. SQL 문 전송 및 실행
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("회원 수정 성공");
            } else {
                System.out.println("회원 수정 실패");
            }

            // 5. 자원 해제
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 회원 삭제
    public void deleteUser(int userId) {
        try {
            // 1. Driver 커넥터 설정
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            System.out.println("1. 드라이버 설정 OK");

            // 2. DB 연결
            String url = "jdbc:mysql://localhost:3306/user_ex";
            String id = "root";
            String password = "0420";
            Connection conn = DriverManager.getConnection(url, id, password);
            System.out.println("2. DB 연결 OK");

            // 3. SQL 문 생성 OK
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            System.out.println("3. SQL 문 생성 OK");

            // 4. SQL 문 전송 및 실행
            int affectRows = pstmt.executeUpdate();
            if (affectRows > 0) {
                System.out.println("회원 삭제 성공");
            } else {
                System.out.println("회원 삭제 실패");
            }

            // 5. 자원 해체
            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
