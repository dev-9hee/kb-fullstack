package beforenoon.ch08.sec04;

public interface RemoteControl {
    // 상수 선언, 불변의 상수 필드를 멤버로 가질 수 있음
    // [public static final] 타입 상수명 = 값; / 인터페이스에 선언된 필드는 모두 public static final 특성
    int MAX_VOLUME = 100;
    int MIN_VOLUME = 0;

    // 추상 메소드, {} 붙이지 않음, public abstract 를 생략하더라도 컴파일 과정에서 자동으로 붙음
    void turnOn();
    void turnOff();
    void setVolume(int volume);

    // sec05
    // 디폴트 인스턴스 메소드, 완전한 실행 코드를 가진 디폴트 메소드 선언 가능
    // 디폴트 메소드는 실행부 있음, default 키워드가 리턴타입 앞에 붙음
    // 실행부({})에는 상수 필드를 읽거나 추상 메소드를 호출하는 코드를 작성할 수 있음
    default void setMute(boolean mute) {
        if (mute) { // mute = true 면 실행
            System.out.println("무음 처리합니다.");
            // 추상 메소드 호출하면서 상수 필드 사용
            setVolume(MIN_VOLUME);
        } else {
            System.out.println("무음 해제 합니다.");
        }
    }

    // sec06, 정적 메소드
    // 구현 객체가 없어도 인터페이스만을 호출할 수 있음, public 를 생랴해도 자동으로 컴파일 과정에서 붙음
    // 정적 실행부를 작성할 때 상수 필드를 제외한 추상 메소드, 디폴트 메소드, private 메소드 등 호출 불가!
    static void changeBattery() {
        System.out.println("리모콘 건전지를 교환합니다.");
    }
}
