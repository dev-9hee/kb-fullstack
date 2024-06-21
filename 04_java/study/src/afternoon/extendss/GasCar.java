package afternoon.extendss;

public class GasCar extends Car {
    @Override
    public void move() { // 부모에서 내려 받은 메서드를 다시 정의(오버라이드) 함
        System.out.println("기름차가 이동합니다!");
    }

    @Override // 지키고 있는지 검사
    public void openDoor() { // 타입, 이름 같아야 함
        System.out.println("기름차 문을 엽니다!");
    }

    public void fillUp() { // 주유 기능
        System.out.println("기름차에 주유합니다.");
    }
}
