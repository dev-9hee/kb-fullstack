package org.scoula.todo;

// UserDao 의 인터페이스, 실제로 구현 될 UserDaoImpl 에 기준이 된다
public interface UserDao {
    // User 관련 기능은 로그인만 필요하므로, 로그인만 구현
    UserVo loginUser(String userId, String password);
}
