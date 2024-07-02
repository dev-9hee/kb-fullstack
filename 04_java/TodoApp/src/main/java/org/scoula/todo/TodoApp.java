package org.scoula.todo;

import org.scoula.lib.cli.App;
import org.scoula.lib.cli.ui.Menu;
import org.scoula.lib.cli.ui.MenuItem;

public class TodoApp extends App {
    @Override
    public void createMenu(Menu menu) {
        super.createMenu(menu);

        menu.add(new MenuItem("목록", null));
        menu.add(new MenuItem("상세", null));
        menu.add(new MenuItem("추가", null));
        menu.add(new MenuItem("수정", null));
        menu.add(new MenuItem("삭제", null));
    }

    public static void main(String[] args) {
        App app = new TodoApp();
        app.run();
    }
}
