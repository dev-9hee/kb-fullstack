package framework.v5;

import framework.v3.command.Command;

// Template 패턴 : 자식 클래스는 커스터마이징을 통해 수정 운영 가능
// 메뉴의 수, 메뉴 구성
public abstract class App {
    Menu menu;

    public App() { }

    public void init(int menuSize) {
        menu = new Menu(menuSize);
        createMenu(menu);
    }

    public void createMenu(Menu menu) {
    }

    public void run() {
        // init(5); 제거
        while(true) {
            menu.printMenu();
            Command command = menu.getSelect();
            command.execute();
        }
    }
}
