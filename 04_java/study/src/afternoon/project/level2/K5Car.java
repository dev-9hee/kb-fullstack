package afternoon.project.level2;

public class K5Car implements Car {
    private int oil; // 멤버 변수
    private static final int EFFICIENCY = 2; // 상수

    // K5Car 생성 시점에 생성자를 통해서 oil 값 초기화
    public K5Car(int oil) {
        this.oil = oil;
    }

    @Override
    public void openDoor() {
        System.out.println("K5, 차 문을 엽니다");
    }

    @Override
    public void drive() {
        System.out.println("K5 주행을 시작 합니다");
        int distance = 0; // 주행 거리

        while (oil >= EFFICIENCY) {
            oil -= EFFICIENCY;
            distance++;
            System.out.println("K5 가 " + distance + "km 를 주행했습니다.");
        }

        System.out.println("K5 가 최종 주행한 거리는 " + distance + "km 입니다.");
        System.out.println("K5 주행 종료");
    }
}
