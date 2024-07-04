package beforenoon.ch07.sec10.exam01;

// new 연산자를 이용해서 객체를 직접 만들지 못하고 상속을 통해 자식 클래스만 만들 수 있음!
public abstract class Phone { // abstract | 추상 클래스
    // 필드 선언
    String owner;

    // 생성자 선언
    Phone(String owner) {
        this.owner = owner;
    }

    // 메소드 선언
    void turnOn() {
        System.out.println("폰 전원을 켭니다.");
    }

    void turnOff() {
        System.out.println("폰 전원을 끕니다.");
    }
}
