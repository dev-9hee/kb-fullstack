package beforenoon.ch06.sec07.exam04;

public class Car {
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    Car() {
    } // 디폴트 생성자

    Car(String model) { // 매개변수로 model만 가지는 생성자
        this.model = model;
    }

    Car(String model, String color) { // 매개변수로 model과 color를 가지는 생성자
        this.model = model;
        this.color = color;
    }

    Car(String model, String color, int maxSpeed) { // 매개변수로 color, maxSpeed를 가지는 생성자
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
