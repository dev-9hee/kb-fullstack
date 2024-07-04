package beforenoon.ch06.sec06.exam01;

public class Car {
    // 필드 선언
    String model; // 기본값 : null
    boolean start; // 기본값 : false
    int speed; // 기본값 : 0
}

class CarMain { // 기본값 확인해보기
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println("모델은 : " + car.model);
        System.out.println("start 값은 : " + car.start);
        System.out.println("speed 값은 : " + car.speed);
    }
}
