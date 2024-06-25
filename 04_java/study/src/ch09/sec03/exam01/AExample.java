package ch09.sec03.exam01;

public class AExample {
    public static void main(String[] args) {
        // B 객체 생성
        // 정적 중첩 클래스(static nested class)를 인스턴스화할 때 사용하는 방법
        // 정적 중첩 클래스는 외부 클래스의 인스턴스 없이도 생성
        A.B b = new A.B();

        // 정적 중첩 클래스 (Static Nested Class):
        //
        //static 키워드로 선언됩니다.
        //외부 클래스의 인스턴스 없이 인스턴스화할 수 있습니다.
        //외부 클래스의 정적 멤버에만 접근할 수 있습니다.
    }
}
