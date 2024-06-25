package ch09.sec04.exam01;

// 로컬 클래스 : 생성자 또는 메소드 내부에서 선언된 클래스
// 생성자와 메소드가 실행될 동안에만 객체를 생성할 수 있음
public class A {
    // 생성자
    A() {
        // 로컬 클래스 선언
        class B { }

        // 로컬 객체 생성
        B b = new B();
    }

    // 메소드
    void method() {
        // 로컬 클래스 선언
        class B { }

        // 로컬 객체 생성
        B b = new B();
    }
}
