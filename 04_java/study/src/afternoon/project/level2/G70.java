package afternoon.project.level2;

public class G70 implements Car {
    private int oil; // 멤버 변수
    private static final int EFFICIENCY = 5; // 상수

    public G70(int oil) {
        this.oil = oil;
    }

    @Override
    public void openDoor() {
        System.out.println("G70, 차 문을 엽니다");
    }

    @Override
    public void drive() {
        System.out.println("G70 주행을 시작 합니다");
        int distance = 0; // 주행 거리

        while (oil >= EFFICIENCY) {
            oil -= EFFICIENCY;
            distance++;
            System.out.println("G70 이 " + distance + "km 를 주행했습니다.");
        }

        System.out.println("G70 이 최종 주행한 거리는 " + distance + "km 입니다.");
        System.out.println("G70 주행 종료");
    }
}
