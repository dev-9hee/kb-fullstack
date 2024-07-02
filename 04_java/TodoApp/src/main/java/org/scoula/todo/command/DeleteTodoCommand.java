package org.scoula.todo.command;

import org.scoula.lib.cli.command.Command;
import org.scoula.lib.cli.ui.Input;
import org.scoula.todo.dao.TodoDao;

public class DeleteTodoCommand implements Command {
    TodoDao dao = TodoDao.getInstance();

    @Override
    public void execute() {
        int id = Input.getInt("삭제할 Todo Id: ");
        dao.delete(id);

        System.out.println();
    }
}
