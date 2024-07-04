package beforenoon.ch06.sec13.exam02.package1;

public class A {
    // 필드 선언
    A a1 = new A(true);
    A a2 = new A(1);
    A a3 = new A("문자열");

    // public 접근 제한 생성자 선언, 모든 패키지
    public A(boolean b) {}

    // default 접근 제한 생성자 선언, 같은 패키지 내에서만!
    A(int b) {}

    // private 접근 제한 생성자 선언, 클래스 내부에서만 생성자 호출 가능/객체 생성
    private A(String b) {}
}
