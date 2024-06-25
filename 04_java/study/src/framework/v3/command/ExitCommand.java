package framework.v3.command;

public class ExitCommand implements Command{
    @Override
    public void execute() {
        System.out.println("프로그램 종료");
        System.exit(0); // 종료 상태 코드는 프로그램이 종료될 때 운영 체제에 반환되는 값, 0이 정상 종료!!
    }
}
