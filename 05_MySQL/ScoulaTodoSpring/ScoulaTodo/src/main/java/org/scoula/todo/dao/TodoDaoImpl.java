package org.scoula.todo.dao;

import org.scoula.todo.common.JDBCUtil;
import org.scoula.todo.domain.TodoV0;
import org.scoula.todo.dto.PageRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TodoDaoImpl implements TodoDao {
    Connection conn = JDBCUtil.getConnection();

    @Override
    public int getTotalCount(String userId) throws SQLException {
        String sql = "select count(*) from todo where userid=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    @Override
    public int create(TodoV0 todo) throws SQLException {
        String sql = "insert into todo(title, description, done, userid) values(?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, todo.getTitle());
            pstmt.setString(2, todo.getDescription());
            pstmt.setBoolean(3, todo.getDone());
            pstmt.setString(4, todo.getUserId());
            return pstmt.executeUpdate();
        }
    }

    private TodoV0 map(ResultSet rs) throws SQLException {
        TodoV0 todo = new TodoV0();
        todo.setId(rs.getLong("id"));
        todo.setTitle(rs.getString("title"));
        todo.setDescription(rs.getString("description"));
        todo.setDone(rs.getBoolean("done"));
        todo.setUserId(rs.getString("userid"));
        return todo;
    }

    private List<TodoV0> mapList(ResultSet rs) throws SQLException {
        List<TodoV0> todoList = new ArrayList<>();
        while (rs.next()) {
            TodoV0 todo = map(rs);
            todoList.add(todo);
        }
        return todoList;
    }

    @Override
    public List<TodoV0> getList(String user) throws SQLException {
        String sql = "select * from todo where userid=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user);
            try (ResultSet rs = pstmt.executeQuery()) {
                return mapList(rs);
            }
        }
    }

    @Override
    public Optional<TodoV0> get(String userId, Long id) throws SQLException {
        String sql = "select * from todo where userid=? and id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setLong(2, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(map(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<TodoV0> search(String userId, String keyword) throws SQLException {
        String sql = "select * from todo where userid=? and (title like ? or description like ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, keyword);
            pstmt.setString(3, keyword);
            try (ResultSet rs = pstmt.executeQuery()) {
                return mapList(rs);
            }
        }
    }

    @Override
    public int update(String userId, TodoV0 todo) throws SQLException {
        String sql = "update todo set title=?, description=?, done=? where userId=? and id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, todo.getTitle());
            pstmt.setString(2, todo.getDescription());
            pstmt.setBoolean(3, todo.getDone());
            pstmt.setString(4, userId);
            pstmt.setLong(5, todo.getId());
            return pstmt.executeUpdate();
        }
    }

    @Override
    public int delete(String userId, Long id) throws SQLException {
        String sql = "delete from todo where userid=? and id=?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setLong(2, id);
            return pstmt.executeUpdate();
        }
    }

    // 페이지네이션
    @Override
    public List<TodoV0> getPage(String userId, PageRequest request) throws SQLException {
        String sql = "select * from todo where userId=? limit ?, ?"; // limit : 한 페이지 당 데이터 건수 설정

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setInt(2, request.getOffset());
            pstmt.setInt(3, request.getSize());

            try (ResultSet rs = pstmt.executeQuery()) {
                return mapList(rs);
            }
        }
    }
}
