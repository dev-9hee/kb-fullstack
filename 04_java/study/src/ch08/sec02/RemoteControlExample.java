package ch08.sec02;

public class RemoteControlExample {
    public static void main(String[] args) {
        // 인터페이스는 참조 타입에 속함
        RemoteControl rc;
        // RemoteControl rc = null; // 객체를 참조하고 있지 않다는 뜻으로 null 대입 가능

        // 인터페이스를 통해 구현 객체를 사용하려면, 인터페이스 변수에 구현 객체의 번지를 대입
        // rc 변수에 Television 객체를 대입
        rc = new Television();
        rc.turnOn();

        // rc 변수에 Audio 객체를 대입
        rc = new Audio();
        rc.turnOn();
    }
}
