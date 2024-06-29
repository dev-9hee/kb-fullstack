package org.scoula.studentscore;

import org.scoula.lib.cli.App;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;
import org.scoula.studentscore.command.AnalizeCommand;
import org.scoula.studentscore.command.GetScoresCommand;
import org.scoula.studentscore.command.InitScoresCommand;
import org.scoula.studentscore.command.PrintScoreCommand;

public class StudentScoreApp extends App {
    @Override
    public void createMenu(Menu menu) {
//        menu.add(new MenuItem("학생수", new InitScoresCommand()));
//        menu.add(new MenuItem("점수입력", new GetScoresCommand()));
//        menu.add(new MenuItem("점수리스트", new PrintScoreCommand()));
//        menu.add(new MenuItem("분석", new AnalizeCommand()));
    }

    public static void main(String[] args) {
        App app = new StudentScoreApp();
        app.run();
    }
}
