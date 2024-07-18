package org.scoula.todo;

public interface UserDao {
    UserVo loginUser(String userId, String password);
}
