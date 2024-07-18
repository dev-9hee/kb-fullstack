package org.scoula.todo.service;

import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.context.Context;
import org.scoula.todo.dao.UserDao;
import org.scoula.todo.dao.UserDaoImpl;
import org.scoula.todo.domain.UserVO;
import org.scoula.todo.exception.LoginFailException;

import java.sql.SQLException;

public class LoginService {
    UserDao dao = new UserDaoImpl();
    public void login() throws SQLException, LoginFailException
    {
        String username = Input.getLine("사용자 ID: ");
        String password = Input.getLine("비밀번호: ");
        UserVO user = dao.get(username).orElseThrow(LoginFailException::new);
        if(user.getPassword().equals(password)) {
            Context ctx = Context.getContext();
            ctx.setUser(user);
        } else {
            throw new LoginFailException();
        }
    }
}
