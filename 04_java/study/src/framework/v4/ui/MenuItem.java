package framework.v4.ui;

import framework.v3.command.Command;

// 문제점 : 메뉴가 하드 코딩되어 있음, 메뉴 타이틀과 Command 분리 운영 문제점
// 해결 : 주입(injection)을 통해 구성할 수 있도록 함, 캡슐화로 해결(MenuItem 클래스로 메뉴 타이틀과 Command 를 캡슐화)
public class MenuItem {
    String title; // 메뉴 문자열
    Command command;

    public MenuItem(String title, Command command) {
        this.title = title;
        this.command = command;
    }

    public String getTitle() {
        return title;
    }

    public Command getCommand() {
        return command;
    }
}
