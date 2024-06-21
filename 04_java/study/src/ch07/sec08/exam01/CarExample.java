package ch07.sec08.exam01;

public class CarExample {
    public static void main(String[] args) {
        // Car 객체 생성
        Car myCar = new Car();

        // 필드 다형성 : 필드 타입은 동일하지만, 대입되는 객체가 다라져서 실행 결과가 다양하게 나올 수 있는 것
        // Tire 객체 장착
        myCar.tire = new Tire();
        myCar.run();

        // HankookTire 객체 장착
        myCar.tire = new HankookTire();
        myCar.run();

        // KumhoTire 객체 장착
        myCar.tire = new KumhoTire();
        myCar.run();
    }
}
