package framework.v6;

import framework.v3.command.*;

public class MyApp extends App {
    @Override
    public void createMenu(Menu menu) {
        super.createMenu(menu);

        menu.add(new MenuItem("학생수", new InitScoresCommand()));
        menu.add(new MenuItem("점수입력", new GetScoresCommand()));
        menu.add(new MenuItem("점수리스트", new PrintScoreCommand()));
        menu.add(new MenuItem("분석", new AnalizeCommand()));
    }

    public static void main(String[] args) {
        App app = new MyApp();
        app.run();
    }

    // 문제점
    // 1. 동일한 구조로 다른 프로젝트에서 사용하기 힘듦 -> MyApp 을 제외한 나머지 부분을 라이브러리화
}
