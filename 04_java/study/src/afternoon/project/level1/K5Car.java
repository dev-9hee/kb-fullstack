package afternoon.project.level1;

public class K5Car implements Car {
    @Override
    public void openDoor() {
        System.out.println("K5, 차 문을 엽니다");
    }

    @Override
    public void drive() {
        System.out.println("K5 주행을 시작 합니다");
        System.out.println("K5 주행 종료");
    }
}
