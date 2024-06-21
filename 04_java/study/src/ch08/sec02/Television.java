package ch08.sec02;

public class Television implements RemoteControl { // implements, 구현 클래스 선언
    // 인터페이스에 선언된 추상 메서드와 동일한 선언부를 가진(재정의된) 메서드를 가지고 있어야 함
    // 인터페이스에 선언된 turnOn() 추상 메서드 재정의
    @Override
    public void turnOn() {
        System.out.println("TV를 켭니다.");
    }
}
