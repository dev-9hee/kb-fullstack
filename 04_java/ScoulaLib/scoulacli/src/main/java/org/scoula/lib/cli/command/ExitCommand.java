package org.scoula.lib.cli.command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("프로그램 종료");
        System.exit(0);
    }
}
