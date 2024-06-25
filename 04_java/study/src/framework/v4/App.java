package framework.v4;

import framework.v3.command.*;
import framework.v4.ui.Menu;
import framework.v4.ui.MenuItem;

public class App {
    Menu menu;

    public App() {
    }

    public void init(int menuSize) {
        menu = new Menu(menuSize);
        createMenu(menu);
    }

    // 어떻게 add 하냐에 따라서 메뉴가 결정됨
    public void createMenu(Menu menu) {
        menu.add(0, new MenuItem("학생수", new InitScoresCommand()));
        menu.add(1, new MenuItem("점수입력", new GetScoresCommand()));
        menu.add(2, new MenuItem("점수리스트", new PrintScoreCommand()));
        menu.add(3, new MenuItem("분석", new AnalizeCommand()));
        menu.add(4, new MenuItem("종료", new ExitCommand()));
    }

    public void run() {
        init(5); // 메뉴의 갯수
        while (true) {
            menu.printMenu();
            Command command = menu.getSelect();
            command.execute();
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
