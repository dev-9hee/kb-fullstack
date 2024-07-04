package beforenoon.ch09.sec03.exam02;

public class AExample {
    public static void main(String[] args) {
        // B 객체 생성 및 인스턴스 필드 및 메소드 사용
        A.B b = new A.B();
        System.out.println(b.field1);
        b.method1();

        // B 클래스의 정적 필드 및 메소드 사용
        // B가 A 클래스 내부의 정적 중첩 클래스이기 때문에, 정적 멤버(필드 및 메소드)에 접근할 때는 A.B를 통해 접근
        System.out.println(A.B.field2);
        A.B.method2();
    }
}
