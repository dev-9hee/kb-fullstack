package org.scoula.todo;

import org.scoula.common.JDBCUtil;

import java.sql.*;

public class UserDaoImpl implements UserDao{

    private final Connection conn;

    public UserDaoImpl() {
        this.conn =  JDBCUtil.getConnection();
    }

    @Override
    public UserVo loginUser(String userId, String password) {

        String sql = "SELECT * FROM todo_user WHERE user_id=? AND password=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    UserVo loginUser = new UserVo(
                            rs.getString("user_id"),
                            rs.getString("name"),
                            rs.getString("password"),
                            rs.getTimestamp("created_at")
                    );
                    return loginUser;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
