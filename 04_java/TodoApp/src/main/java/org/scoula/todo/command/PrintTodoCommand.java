package org.scoula.todo.command;

import org.scoula.lib.cli.command.Command;
import org.scoula.todo.dao.TodoDao;
import org.scoula.todo.domain.Todo;

public class PrintTodoCommand implements Command {
    TodoDao dao = TodoDao.getInstance();

    @Override
    public void execute() {
    }
}
