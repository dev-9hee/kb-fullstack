package beforenoon.ch06.sec13.exam02.package2;

import beforenoon.ch06.sec13.exam02.package1.A;

public class C {
    // 필드 선언
    A a1 = new A(true); // 가능, 모든 패키지
//    A a2 = new A(1); // default 생성자 접근 불가
//    A a3 = new A("문자열"); // private 생성자 접근 불가
}
