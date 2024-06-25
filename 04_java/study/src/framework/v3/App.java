package framework.v3;

import framework.v2.Menu;
import framework.v3.command.*;

// 문제점 : 기능이 추가된다면
// 추가 기능의 Command 구현체 작성, 메뉴에 항목 추가(현재는 고정되어 있음), 메뉴와 Command 가 분리되어 운영(불일치 발생 가능)
public class App {
    Menu menu;
    Command[] commands;

    public App() {
        menu = new Menu();
        commands = new Command[] {
                new InitScoresCommand(),
                new GetScoresCommand(),
                new PrintScoreCommand(),
                new AnalizeCommand(),
                new ExitCommand()
        };
    }

    public void executeCommand(int selectNo) {
        Command command = commands[selectNo-1];
        command.execute();
    }

    public void run() {
        while(true) {
            menu.printMenu();
            int selectNo = menu.getSelect();
            executeCommand(selectNo);
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
