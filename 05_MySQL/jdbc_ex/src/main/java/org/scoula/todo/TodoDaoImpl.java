package org.scoula.todo;

import org.scoula.common.JDBCUtil;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class TodoDaoImpl implements TodoDao {

    @Override
    public int getTotalCount(String userId) { // 총 투두 개수
        Connection conn = JDBCUtil.getConnection();
        String sql = "select count(*) from todo2 where user_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void getTodosByUserId(String userId) { // 전체 목록 조회
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from todo2 where user_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("===== " + userId + "님의 Todo 전체 목록 =====");
                while (rs.next()) {
                    TodoVo todo = new TodoVo(
                            rs.getInt("id"),
                            rs.getString("user_id"),
                            rs.getString("todo"),
                            rs.getBoolean("is_completed"),
                            rs.getTimestamp("created_at")
                    );
                    System.out.println(todo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getCompletedTodosByUserId(String userId) { // 완료 목록 처리
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from todo2 where user_id=? and is_completed=true";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("===== " + userId + "님의 완료 목록 =====");
                while (rs.next()) {
                    TodoVo todo = new TodoVo(
                            rs.getInt("id"),
                            rs.getString("user_id"),
                            rs.getString("todo"),
                            rs.getBoolean("is_completed"),
                            rs.getTimestamp("created_at")
                    );
                    System.out.println(todo);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getUncompletedTodosUserId(String userId) { // 미완료 목록 조회
        Connection conn = JDBCUtil.getConnection();
        String sql = "select * from todo2 where user_id=? and is_completed=false";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("===== " + userId + "님의 미완료 목록 =====");
                while (rs.next()) {
                    TodoVo todo = new TodoVo(
                            rs.getInt("id"),
                            rs.getString("user_id"),
                            rs.getString("todo"),
                            rs.getBoolean("is_completed"),
                            rs.getTimestamp("created_at")
                    );
                    System.out.println(todo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void makeTodoCompleted(int id, String userId) { // 완료 처리
        Connection conn = JDBCUtil.getConnection();
        String sql = "update todo2 set is_completed=true where id=? and user_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, userId);
            ps.executeUpdate();
            if (ps.executeUpdate() > 0) {
                System.out.println("## ID 가 " + id + " 인 Todo 가 완료 처리 되었습니다 ##");
            } else {
                System.out.println("## ID 가 " + id + " 는 회원님의 Todo 가 아닙니다 ##");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTodo(String todo, String userId) { // 추가
        Connection conn = JDBCUtil.getConnection();
        String sql = "insert into todo2(user_id, todo) values(?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            ps.setString(2, todo);
            ps.executeUpdate();
            System.out.println("## Todo 추가 성공! ##");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAllTodosWithUserName() { // 전체 목록 + 작성자 확인
        Connection conn = JDBCUtil.getConnection();
        String sql = "select A.id, A.user_id, B.name, A.todo, A.is_completed, A.created_at from todo2 A inner join todo_user B on A.user_id = B.user_id";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.println("===== Todo 전체 목록 =====");
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id")  + ", user_id: " + rs.getString("user_id") +
                        ", 작성자 이름: " + rs.getString("name") + ", todo: " + rs.getString("todo") +
                        ", is_completed: " + rs.getBoolean("is_completed") + ", created_at: " + rs.getTimestamp("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTodo(int id, String userId) { // 삭제
        Connection conn = JDBCUtil.getConnection();
        String sql = "delete from todo2 where id=? and user_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, userId);
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("## ID 가 " + id + " 인 Todo 가 삭제 처리 되었습니다 ##");
            } else {
                System.out.println("## ID 가 " + id + " 는 회원님의 Todo 가 아닙니다 ##");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
