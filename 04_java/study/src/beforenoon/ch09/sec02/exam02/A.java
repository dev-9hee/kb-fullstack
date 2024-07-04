package beforenoon.ch09.sec02.exam02;

public class A {
    // 인스턴스 멤버 클래스
    class B {
        // 인스턴스 필드, 인스턴스(객체)마다 독립적으로 존재하는 변수
        int field1 = 1;

        // 정적 필드(Java 17부터 허용), 클래스의 모든 인스턴스가 공유하는 변수, 클래스 이름을 통해 접근
        static int field2 = 2;

        // 생성자
        B() {
            System.out.println("B-생성자 실행");
        }

        // 인스턴스 메소드, 클래스의 인스턴스(객체)를 통해 호출되는 메소드, 객체가 생성되어야 호출 가능
        void method1() {
            System.out.println("B-method1 실행");
        }

        // 정적 메소드(Java 17부터 허용), 정적 메소드는 클래스의 인스턴스가 아니라 클래스 자체를 통해 호출되는 메소드
        static void method2() {
            System.out.println("B-method2 실행");
        }
    }

    // 인스턴스 메소드
    void useB() {
        // B 객체 생성 및 인스턴스 필드 및 메소드 사용
        B b = new B(); // B-생성자 실행
        System.out.println(b.field1); // 1
        b.method1(); // B-method1 실행

        // B 클래스의 정적 필드 및 메소드 사용
        System.out.println(B.field2); // 2
        B.method2(); // B-method2 실행
    }
}
