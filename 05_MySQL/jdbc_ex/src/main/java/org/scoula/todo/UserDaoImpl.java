package org.scoula.todo;

import org.scoula.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    private final Connection conn;

    public UserDaoImpl() {
        this.conn = JDBCUtil.getConnection();
    }

    @Override
    public UserVo loginUser(String userId, String password) {
//        Connection conn = JDBCUtil.getConnection();

        String sql = "select * from todo_user where user_id=? and password=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // ResultSet 으로부터 데이터를 가져와서 UserVo 객체를 생성
                    UserVo user = new UserVo(
                            rs.getString("user_id"),
                            rs.getString("name"),
                            rs.getString("password"),
                            rs.getTimestamp("created_at")
                    );
                    return user; // 사용자 객체를 반환
                }
                return null; // 없으면 null 반환
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
