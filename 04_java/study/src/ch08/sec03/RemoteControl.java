package ch08.sec03;

public interface RemoteControl {
    // 상수 선언, 불변의 상수 필드를 멤버로 가질 수 있음
    // [public static final] 타입 상수명 = 값; / 인터페이스에 선언된 필드는 모두 public static final 특성
    int MAX_VOLUME = 100;
    int MIN_VOLUME = 0;
}
