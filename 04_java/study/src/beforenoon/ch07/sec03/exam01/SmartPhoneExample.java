package beforenoon.ch07.sec03.exam01;

public class SmartPhoneExample {
    public static void main(String[] args) {
        // SmartPhone 객체 생성
        SmartPhone myPhone = new SmartPhone("갤럭시", "은색");

        // Phone으로부터 상속 받은 필드 읽기
        System.out.println("모델: " + myPhone.model);
        System.out.println("색상: " + myPhone.color);

        // 결과
//        Phone() 생성자 실행
//        SmartPhone(String model, String color) 생성자 실행됨
//        모델: 갤럭시
//        색상: 은색
    }
}
