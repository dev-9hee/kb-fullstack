package afternoon.poly4;

public class StopHee implements Animal, Human {
    @Override
    public void eat() {
        System.out.println("정지희가 저녁을 먹습니다!");
    }

    @Override
    public void sleep() {
        System.out.println("정지희가 너무 잘 잡니다!");
    }

    @Override
    public void think() {
        System.out.println("정지희가 집에 가서 할 일을 고민 합니다!");
    }
}
