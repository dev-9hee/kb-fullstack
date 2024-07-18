package org.scoula.todo;

import org.scoula.lib.cli.App;
import org.scoula.lib.cli.ui.Input;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;
import org.scoula.todo.config.ProjectConfig;
import org.scoula.todo.context.Context;
import org.scoula.todo.exception.LoginFailException;
import org.scoula.todo.service.AccountService;
import org.scoula.todo.service.LoginService;
import org.scoula.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class TodoApp extends App {
    Menu userMenu; // 로그인한 상태의 메뉴
    Menu anonymousMenu; // 로그아웃한 상태의 메뉴

    /*
    LoginService loginService = new LoginService();
    AccountService accountService = new AccountService();
    private static final TodoService todoService = new TodoService();
     */

    @Autowired
    LoginService loginService;

    @Autowired
    AccountService accountService;

    @Autowired
    TodoService todoService;

//    LoginService loginService = Context.getBean(LoginService.class);
//    AccountService accountService = Context.getBean(AccountService.class);
//    TodoService todoService = Context.getBean(TodoService.class);


    @Override
    public void init() {
        anonymousMenu = new Menu();
        anonymousMenu.add(new MenuItem("로그인", this::login));
        anonymousMenu.add(new MenuItem("가입", accountService::join));
        anonymousMenu.add(new MenuItem("종료", this::exit));

        userMenu = new Menu();
        userMenu.add(new MenuItem("목록", todoService::print));
        userMenu.add(new MenuItem("목록", todoService::printPage)); // 페이지네이션
        userMenu.add(new MenuItem("검색", todoService::search));
        userMenu.add(new MenuItem("상세", todoService::detail));
        userMenu.add(new MenuItem("추가", todoService::create));
        userMenu.add(new MenuItem("수정", todoService::update));
        userMenu.add(new MenuItem("삭제", todoService::delete));

        userMenu.add(new MenuItem("로그아웃", this::logout));
        userMenu.add(new MenuItem("종료", this::exit));

        setMenu(anonymousMenu); // 시작은 anonymousMenu 로
    }

    public void join(){}

    public void login() { // 로그인
        try {
            loginService.login();
            setMenu(userMenu); // 메뉴 교체
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (LoginFailException e) {
            System.out.println(e.getMessage());
        }

    }
    public void logout() { // 로그아웃
        if(Input.confirm("로그아웃 할까요?")) {
            Context.getContext().setUser(null);
            setMenu(anonymousMenu); // 메뉴 교체
        }
    }

    public void exit() {
        System.out.println("프로그램 종료");
        System.exit(0);
    }

    public static void main(final String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
        TodoApp app = ctx.getBean(TodoApp.class);
        app.run();
    }
}
