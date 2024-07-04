package beforenoon.ch12.sec03.exam03;

// 객체 문자 정보
public class SmartPhone {
    private String company;
    private String os;

    // 생성자
    public SmartPhone(String company, String os) {
        this.company = company;
        this.os = os;
    }

    // SmartPhone 클래스의 toString() 메서드를 오버라이드하여 company 와 os 필드의 값을 문자열로 반환하도록 구현
    @Override
    public String toString() {
        return company + ", " + os;
    }
}
