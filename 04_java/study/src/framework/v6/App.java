package framework.v6;

import framework.v3.command.Command;
import framework.v3.command.ExitCommand;

public abstract class App {
    Menu menu;

    public App() {
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
            menu.printMenu();
            Command command = menu.getSelect();
            command.execute();
        }
    }
}
