package framework.v4.ui;

import framework.v2.Input;
import framework.v3.command.Command;

public class Menu {
    MenuItem[] menus;

    public Menu(int size) {
        menus = new MenuItem[size];
    }

    // 메뉴 항목 주입, add 를 통해서 외부에서 구성됨, 메뉴 클래스를 일반화시킴
    public void add(int ix, MenuItem item) {
        menus[ix] = item;
    }

    public void printMenu() {
        System.out.println("--------------------------------------------");
        for(int i=0; i< menus.length; i++) {
            System.out.printf(" %d.%s | ", i+1, menus[i].getTitle());
        }
        System.out.println();
        System.out.println("--------------------------------------------");
    }

    public Command getSelect() {
        int selectNo = Input.getInt("선택> ");
        // 올바른 범위 인지 체크

        return menus[selectNo-1].getCommand();
    }
}
