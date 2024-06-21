package ch07.sec06.package2;

import ch07.sec06.package1.A;

public class C { // protected / 같은 패키지 아니고, 자식 클래스도 아님
    // 메소드 선언
    public void method() {
//        A a = new A(); // 불가
//        a.field = "value"; // 불가
//        a.method(); // 불가
    }
}
