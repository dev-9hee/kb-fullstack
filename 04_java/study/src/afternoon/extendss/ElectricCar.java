package afternoon.extendss;

public class ElectricCar extends Car {
    @Override
    public void move() {
        System.out.println("전기차가 이동합니다.");
    }

    @Override
    public void openDoor() {
        System.out.println("전기차 문을 엽니다!");
    }

    public void charge() { // 충전 기능
        System.out.println("전기차를 충전합니다.");
    }
}
