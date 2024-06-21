package ch07.sec04.exam02;

public class SupersonicAirplane extends Airplane{ // 자식
    // 상수 선언
    // static final 변수는 클래스 수준에서 선언되며, 프로그램 실행 중에 값이 변경되지 않는 상수
    // static 메서드는 클래스 수준에서 선언되며, 객체 생성 없이 호출 가능
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;
    // 상태 필드 선언
    public int flyMode = NORMAL;

    // 메소드 정의

    @Override
    public void fly() {
        if(flyMode == SUPERSONIC) {
            System.out.println("초음속 비행합니다.");
        } else {
            // Airplane 객체의 fly() 메소드 호출
            super.fly(); // "일반 비행합니다."
        }
    }
}
