package beforenoon.ch06.sec07.exam05;

public class Car {
    // 필드 선언
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    Car() {}

    Car(String model) {
        // 다른 생성자 호출
        this(model, null, 0);
    }

    Car(String model, String color) {
        // 다른 생성자 호출
        this(model, color, 0);
    }

    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
