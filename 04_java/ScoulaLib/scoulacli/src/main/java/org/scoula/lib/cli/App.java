package org.scoula.lib.cli;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.command.ExitCommand;
import org.scoula.lib.cli.exception.BadMenuException;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;

public abstract class App {
    Menu menu;

    public App() {
    }

    public void setMenu(Menu menu) { // 로그인 상태에 따라 보여주는 메뉴가 달라져야 하기 때문에 생성
        this.menu = menu;
    }

    public void init() {
        menu = new Menu();
        createMenu(menu);
        menu.add(new MenuItem("종료", new ExitCommand()));
    }

    public void createMenu(Menu menu) {
    }

    public void run() {
        init();
        while(true) {
            try {
                menu.printMenu();
                Command command = menu.getSelect();
                command.execute();
            } catch (Exception e) {
                e.printStackTrace();
                // System.out.println("에러: " + e.getMessage());
            }
        }
    }

}
