package framework.v6;

import framework.v2.Input;
import framework.v3.command.Command;

import java.util.ArrayList;
import java.util.List;

// 메뉴 : 배열로 관리하고 있음 -> 크기 고정
// ArrayList 로 관리
public class Menu {
    List<MenuItem> menus;

    public Menu() {
        menus = new ArrayList<>();
    }

    public void add(MenuItem item) {
        menus.add(item);
    }

    public void printMenu() {
        System.out.println("------------------------------------------------------------------------");
        for (int i=0; i<menus.size(); i++) {
            System.out.printf("%d.%s |", i+1, menus.get(i).getTitle());
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
    }

    public Command getSelect() {
        int selectNo = Input.getInt("선택> ");
        // 올바른 범위 인지 체크

        return menus.get(selectNo-1).getCommand();
    }
}
