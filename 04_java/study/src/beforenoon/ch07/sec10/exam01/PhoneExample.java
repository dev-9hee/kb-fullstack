package beforenoon.ch07.sec10.exam01;

public class PhoneExample {
    public static void main(String[] args) {
        // Phone phone = new Phone(); // (x, 추상클래스로 객체 직접 만들지 못함)

        SmartPhone smartPhone = new SmartPhone("정지희");

        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();
    }
}
