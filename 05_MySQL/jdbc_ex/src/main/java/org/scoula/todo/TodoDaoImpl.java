package org.scoula.todo;

import org.scoula.common.JDBCUtil;

import java.sql.*;

public class TodoDaoImpl implements TodoDao {

    // 접속 정보를 TodoDaoImpl 자체가 가지고 있도록 한 코드
    private final Connection conn;
    // 해당 클래스를 생성하고 사용할 때 DB에 접속이 되면 되므로, 생성 시점에 JDBCUtil 로 부터 접속 정보를 받아서
    // 스스로의 멤버 변수에 보관한다
    public TodoDaoImpl() {
        this.conn = JDBCUtil.getConnection();
    }

    @Override
    public int getTotalCount(String userId) {  // 특정 사용자가 작성한 투두의 개수를 구하는 메서드
//        Connection conn = JDBCUtil.getConnection();
        // SELECT COUNT(*) 쿼리를 이용하여 해당 쿼리문의 수행 결과가 몇개의 데이터를 가져오는지 구하는 쿼리
        String sql = "select count(*) from todo2 where user_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // 데이터의 개수는 COUNT(*)에 의해 첫번째 컬럼에 만들어 졌으므로, 첫번째 컬럼의 값을 가져오기
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 쿼리가 실패하여 while 문이 실행이 안되면 해당 쿼리에 부합하는 DB 데이터가 없는 것이므로 0 을 리턴
        return 0;
    }

    // 로그인한 사용자가 작성한 투두를 검색
    @Override
    public void getTodosByUserId(String userId) { // 전체 목록 조회
//        Connection conn = JDBCUtil.getConnection();
        // 투두 DB 중에서 특정 작성자가 작성한 투두 전부를 가져오는 쿼리
        String sql = "select * from todo2 where user_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                boolean hasResults = false; // 결과가 있는지 여부를 추적하는 플래그
                System.out.println("===== " + userId + "님의 Todo 전체 목록 =====");
                while (rs.next()) {
                    hasResults = true; // 결과가 있는 경우
                    TodoVo todo = new TodoVo(
                            rs.getInt("id"),
                            rs.getString("user_id"),
                            rs.getString("todo"),
                            rs.getBoolean("is_completed"),
                            rs.getTimestamp("created_at")
                    );
                    System.out.println(todo);
                }
                if (!hasResults) { // 결과가 없을 경우
                    System.out.println("## 작성하신 Todo 목록이 없습니다. ##");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 위와 같이 특정 사용자가 작성하였으나 완료 여부가 True 것만 검색하는 메서드
    @Override
    public void getCompletedTodosByUserId(String userId) { // 완료 목록 처리
//        Connection conn = JDBCUtil.getConnection();
        // 쿼리문의 검색 조건에 is_completed 가 true 인 것만 추가되고 나머지는 전부 동일
        String sql = "select * from todo2 where user_id=? and is_completed=true";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                boolean hasResults = false; // 결과가 있는지 여부를 추적하는 플래그
                System.out.println("===== " + userId + "님의 완료 목록 =====");
                while (rs.next()) {
                    hasResults = true; // 결과가 있는 경우
                    TodoVo todo = new TodoVo(
                            rs.getInt("id"),
                            rs.getString("user_id"),
                            rs.getString("todo"),
                            rs.getBoolean("is_completed"),
                            rs.getTimestamp("created_at")
                    );
                    System.out.println(todo);
                }
                if (!hasResults) { // 결과가 없을 경우
                    System.out.println("## 완료 목록이 없습니다. ##");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 위와 같이 특정 사용자가 작성하였으나 완료 여부가 False 인 것만 검색하는 메서드
    @Override
    public void getUncompletedTodosUserId(String userId) { // 미완료 목록 조회
//        Connection conn = JDBCUtil.getConnection();
        // 쿼리문의 검색 조건에 is_completed 가 false 인 것만 추가되고 나머지는 전부 동일
        String sql = "select * from todo2 where user_id=? and is_completed=false";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                boolean hasResults = false; // 결과가 있는지 여부를 추적하는 플래그
                System.out.println("===== " + userId + "님의 미완료 목록 =====");
                while (rs.next()) {
                    hasResults = true; // 결과가 있는 경우
                    TodoVo todo = new TodoVo(
                            rs.getInt("id"),
                            rs.getString("user_id"),
                            rs.getString("todo"),
                            rs.getBoolean("is_completed"),
                            rs.getTimestamp("created_at")
                    );
                    System.out.println(todo);
                }
                if (!hasResults) { // 결과가 없을 경우
                    System.out.println("## 미완료 목록이 없습니다. ##");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 특정 사용자가 작성한 투두의 완료 여부를 변경하는 메서드
    @Override
    public void makeTodoCompleted(int id, String userId) { // 완료 처리
//        Connection conn = JDBCUtil.getConnection();
        // SET 명령어로 is_completed 컬럼의 값을 True 로 변경하는 쿼리
        // TodoList 는 PrimaryKey 역할을 하는 id 를 조건으로 검색
        // 단, 자기가 작성한 투두만 수정이 가능해야 하므로 user_id 검색 조건도 같이 걸어준다!!!
        String sql = "update todo2 set is_completed=true where id=? and user_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, userId);

            // 해당 쿼리는 1개의 투두 리스트의 완료 여부를 변경하는 것이므로 해당 쿼리가 정상적으로 수행되면
            // 1개의 데이터가 변경되어야 한다 -> 따라서, ps.executeUpdate() 의 리턴 값은 1이 나와야 하는 상태
            int affectedRows = ps.executeUpdate();
            // 따라서 리턴 된, affectedRows 값이 0 이면 쿼리가 실패한 케이스 0 이상이면 성공한 케이스로 간주하고
            // if 문을 사용하여 상황에 맞는 결과를 출력
            if (affectedRows > 0) {
                System.out.println("## ID 가 " + id + " 인 Todo 가 완료 처리 되었습니다 ##");
            } else {
                System.out.println("## ID 가 " + id + " 는 회원님의 Todo 가 아닙니다 ##");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 새로운 투두를 작성하는 메서드
    @Override
    public void createTodo(String todo, String userId) { // 추가
//        Connection conn = JDBCUtil.getConnection();
        String sql = "insert into todo2(user_id, todo) values(?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            ps.setString(2, todo);
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("## Todo 추가 성공! ##");
            } else {
                System.out.println("## Todo 추가 실패! ##");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 작성 된 투두를 삭제하는 메서드
    @Override
    public void deleteTodo(int id, String userId) { // 삭제
//        Connection conn = JDBCUtil.getConnection();
        // 수정과 마찬가지로 id 를 이용해서 삭제를 시도, 단 자신이 작성한 투두만 지워야 하므로
        // user_id 조건을 통해 자신이 작성한 투두 인지를 확인한다
        String sql = "delete from todo2 where id=? and user_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, userId);

            // 하나의 데이터를 삭제하는 쿼리를 수행했으므로 쿼리가 성공하면 삭제된 데이터의 개수가 1이므로
            // 리턴은 1, 실패하면 0 이 들어오는 상황이므로 상황에 맞는 결과문 출력
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("## ID 가 " + id + " 인 Todo 가 삭제 처리 되었습니다 ##");
            } else {
                System.out.println("## ID 가 " + id + " 는 회원님의 Todo 가 아닙니다 ##");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 두 테이블을 합쳐서(JOIN) 하여 새로운 데이터를 출력하는 메서드
    @Override
    public void getAllTodosWithUserName() { // 전체 목록 + 작성자 확인
//        Connection conn = JDBCUtil.getConnection();
        String sql = "select A.id, A.user_id, B.name, A.todo, A.is_completed, A.created_at from todo2 A inner join todo_user B on A.user_id = B.user_id";

        // 해당 쿼리는 값이 변하지 않으므로 PreparedStatement 가 아닌 고정 쿼리인 Statement 를 사용
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) { // 쿼리 실행 결과 데이터를 ResultSet 에 저장
            System.out.println("===== Todo 전체 목록 =====");
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id")  + ", user_id: " + rs.getString("user_id") +
                        ", 작성자 이름: " + rs.getString("name") + ", todo: " + rs.getString("todo") +
                        ", is_completed: " + rs.getBoolean("is_completed") + ", created_at: " + rs.getTimestamp("created_at"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
