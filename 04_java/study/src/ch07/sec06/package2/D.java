package ch07.sec06.package2;

import ch07.sec06.package1.A;

public class D extends A{
    // 다른 패키지일 경우, 상속을 통해서만 가능
    public D() {
        // A() 생성자 호출
        super(); // 가능
    }

    public void method1() {
        // A 필드값 변경
        this.field = "value"; // 가능
        // A 메소드 호출
        this.method(); // 가능
    }

    // 메소드 선언
    public void method2() {
        // 직접 객체 생성해서 사용하는 것은 안 됨
//        A a = new A(); // 불가
//        a.field = "value"; // 불가
//        a.method(); // 불가
    }
}
