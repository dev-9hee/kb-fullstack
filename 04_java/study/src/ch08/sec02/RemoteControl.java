package ch08.sec02;

// 인터페이스 선언 => 두 객체를 연결하는 역할, 다형성 구현에 주된 기술, class 키워드 대신 interface 키워드 사용
// 접근 제한자 => default(기본), public 사용 가능
public interface RemoteControl {
    // public 추상 메소드
    // 추상 메소드는 구현부가 없는 메소드로, 인터페이스를 구현하는 클래스에서 반드시 구현
    public void turnOn();
}
