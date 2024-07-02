package org.scoula.todo;

import org.scoula.lib.cli.App;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;
import org.scoula.todo.command.DeleteTodoCommand;
import org.scoula.todo.command.DetailTodoCommand;
import org.scoula.todo.command.PrintTodoCommand;

public class TodoApp extends App {
    @Override
    public void createMenu(Menu menu) {
        super.createMenu(menu);

        menu.add(new MenuItem("목록", new PrintTodoCommand()));
        menu.add(new MenuItem("상세", new DetailTodoCommand()));
        menu.add(new MenuItem("추가", null));
        menu.add(new MenuItem("수정", null));
        menu.add(new MenuItem("삭제", new DeleteTodoCommand()));
    }

    public static void main(String[] args) {
        App app = new TodoApp();
        app.run();
    }
}
