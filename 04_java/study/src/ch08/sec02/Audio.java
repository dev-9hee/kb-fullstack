package ch08.sec02;

public class Audio implements RemoteControl {
    // 인터페이스에 선언된 turnOn() 추상 메서드 재정의
    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }
}
