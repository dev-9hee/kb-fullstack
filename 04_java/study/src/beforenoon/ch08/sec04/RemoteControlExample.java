package beforenoon.ch08.sec04;

public class RemoteControlExample {
    public static void main(String[] args) {
        // 인터페이스 변수 선언
        RemoteControl rc;

        // Television 객체를 생성하고 인터페이스 변수에 대입
        rc = new Television();
        rc.turnOn();
        rc.setVolume(5);

        // sec05, 디폴트 메소드 호출
        rc.setMute(true);
        rc.setMute(false);

        rc.turnOff();

        System.out.println();

        // Audio 객체를 생성하고 인터페이스 변수에 대입
        rc = new Audio();
        rc.turnOn();
        rc.setVolume(5);

        // sec05, 디폴트 메소드 호출
        rc.setMute(true);
        rc.setMute(false);

        rc.turnOff();

        System.out.println();

        // sec06, 정적 메소드 호출, 구현 객체가 없어도 인터페이스만을 호출 가능
        RemoteControl.changeBattery();
    }
}
