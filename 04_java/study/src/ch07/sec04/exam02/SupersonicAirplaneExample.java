package ch07.sec04.exam02;

public class SupersonicAirplaneExample {
    public static void main(String[] args) {
        SupersonicAirplane sa = new SupersonicAirplane();

        sa.tackOff(); // 이륙합니다
        sa.fly(); // 일반 비행
        sa.flyMode = SupersonicAirplane.SUPERSONIC; // 초음속 비행 설정
        sa.fly(); // 초음속 비행
        sa.flyMode = SupersonicAirplane.NORMAL; // 일반 비행 설정
        sa.fly(); // 일반 비행
        sa.land(); // 착륙합니다
    }
}
