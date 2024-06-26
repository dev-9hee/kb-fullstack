package framework.v5;

import framework.v3.command.*;
import framework.v4.ui.MenuItem;

public class MyApp extends App{
    @Override
    public void createMenu(Menu menu) {
        super.createMenu(menu);

        menu.add(0, new framework.v4.ui.MenuItem("학생수", new InitScoresCommand()));
        menu.add(1, new framework.v4.ui.MenuItem("점수입력", new GetScoresCommand()));
        menu.add(2, new framework.v4.ui.MenuItem("점수리스트", new PrintScoreCommand()));
        menu.add(3, new framework.v4.ui.MenuItem("분석", new AnalizeCommand()));
        menu.add(4, new MenuItem("종료", new ExitCommand()));
    }

    public static void main(String[] args) {
        App app = new MyApp();
        app.init(5);
        app.run();
    }

    // 문제점
    // 1. 배열로 관리하기 때문에 크기 및 등록 시 인덱스 정보 필요 -> ArrayList 로 관리
    // 2. 너무 많은 Command 객체가 생성됨 -> 메서드 참조를 통해 해결
}
