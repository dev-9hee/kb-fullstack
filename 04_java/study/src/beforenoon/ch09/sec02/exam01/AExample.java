package beforenoon.ch09.sec02.exam01;

public class AExample {
    public static void main(String[] args) {
        // A는 외부 클래스, B는 내부 클래스(inner class)
        // 이는 클래스 A의 인스턴스와 연관되어 있으며, 외부 클래스의 인스턴스가 있어야만 생성될 수 있다.


        // A 객체 생성
        A a = new A(); // A의 객체 a를 생성

        // B 객체 생성
        A.B b = a.new B(); // 내부 클래스 B를 인스턴스화하기 위해서는 외부 클래스 A의 인스턴스 a가 필요

        // 인스턴스 멤버 클래스 (Instance Member Class):
        //
        //외부 클래스의 인스턴스와 연결됩니다.
        //외부 클래스의 인스턴스가 있어야 인스턴스화할 수 있습니다.
        //외부 클래스의 모든 멤버 (정적 및 인스턴스)에 접근할 수 있습니다.
    }
}
