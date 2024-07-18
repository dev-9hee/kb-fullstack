package org.scoula.todo.dao;

import org.scoula.todo.common.JDBCUtil;
import org.scoula.todo.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// UserDao 인터페이스를 구현한 UserDaoImpl 클래스
// 데이터베이스의 users 테이블에 대한 CRUD(생성, 읽기, 수정, 삭제) 작업을 실제로 수행
// JDBCUtil 유틸리티 클래스를 사용하여 데이터베이스 연결을 처리
@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    Connection conn;
    //    Connection conn = JDBCUtil.getConnection(); // 데이터베이스 연결을 가져오는 멤버 변수
    // USERS 테이블 관련 SQL 명령어, 각 CRUD 작업을 위한 SQL 명령어를 문자열로 정의
    private String USER_LIST = "select * from users";
    private String USER_GET = "select * from users where id = ?";
    private String USER_INSERT = "insert into users values(?, ?, ?, ?)";
    private String USER_UPDATE = "update users set name = ?, role = ? where id = ?";
    private String USER_DELETE = "delete from users where id = ?";

    // 회원 등록
    @Override
    public int create(UserVO user) throws SQLException { // 새로운 사용자를 데이터베이스에 등록
        try (PreparedStatement stmt = conn.prepareStatement(USER_INSERT)) {
            // UserVO 객체의 속성값을 SQL 명령어의 ? 자리에 설정
            stmt.setString(1, user.getId());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getRole());
            return stmt.executeUpdate(); // SQL 명령어를 실행하고 영향을 받은 행 수를 반환
        }
    }

    private UserVO map(ResultSet rs) throws SQLException { // ResultSet 객체를 UserVO 객체로 매핑
        UserVO user = new UserVO();
        // rs.getString(...) : 결과 집합에서 각 열의 값을 가져와 UserVO 객체의 속성에 설정
        user.setId(rs.getString("ID"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setName(rs.getString("NAME"));
        user.setRole(rs.getString("ROLE"));
        return user;
    }

    // 회원 목록 조회
    @Override
    public List<UserVO> getList() throws SQLException { // 모든 사용자 정보를 조회
        List<UserVO> userList = new ArrayList<UserVO>();
        Connection conn = JDBCUtil.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(USER_LIST);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) { // 결과 집합의 각 행을 UserVO 객체로 매핑하고 리스트에 추가
                UserVO user = map(rs);
                userList.add(user);
            }
        }
        return userList;
    }

    // 회원 정보 조회
    @Override
    public Optional<UserVO> get(String id) throws SQLException { // 주어진 ID를 가진 사용자의 정보를 조회
        try (PreparedStatement stmt = conn.prepareStatement(USER_GET)) {
            stmt.setString(1, id); // id 값을 SQL 명령어의 ? 자리에 설정
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) { // 결과가 존재하면 UserVO 객체로 매핑하고 반환
                    return Optional.of(map(rs));
                }
            }
        }
        return Optional.empty();
    }

    // 회원 수정
    @Override
    public int update(UserVO user) throws SQLException { // 사용자의 정보를 수정
        Connection conn = JDBCUtil.getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(USER_UPDATE)) {
            // 수정할 값들을 SQL 명령어의 ? 자리에 설정
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getRole());
            stmt.setString(3, user.getId());
            return stmt.executeUpdate(); // SQL 명령어를 실행하고 영향을 받은 행 수를 반환
        }
    }

    // USERS 테이블 관련 CRUD 메소드
    // 회원 삭제
    @Override
    public int delete(String id) throws SQLException { // 주어진 ID를 가진 사용자를 삭제
        try (PreparedStatement stmt = conn.prepareStatement(USER_DELETE)) {
            stmt.setString(1, id); // id 값을 SQL 명령어의 ? 자리에 설정
            return stmt.executeUpdate(); // SQL 명령어를 실행하고 영향을 받은 행 수를 반환
        }
    }
}
