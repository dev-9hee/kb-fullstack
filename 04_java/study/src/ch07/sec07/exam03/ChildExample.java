package ch07.sec07.exam03;

public class ChildExample {
    public static void main(String[] args) {
        // 객체 생성 및 자동 타입 변환
        // 자식 객체가 부모 타입으로 자동 변환하면 부모 타입에 선언된 필드와 메소드만 사용 가능
        Parent parent = new Child();

        // Parent 타입으로 필드와 메소드 사용
        parent.field1 = "data2";
        parent.method1(); // Parent-method1()
        parent.method2(); // Parent-method2()
        /*
        parent.field2 = "data2"; // 불가능
        parent.method3(); // 불가능
        */

        // 강제 타입 변환
        // 부모 타입은 자식 타입으로 자동변환되지 않음, 대신 캐스팅 연산자로 강제 타입 변환 가능
        // 자식타입 변수 = (자식타입) 부모타입객체, (Child) 캐스팅 연산자
        Child child = (Child) parent;

        // Child 타입으로 필드와 메소드 사용
        child.field2 = "data2"; // 가능
        child.method3(); // 가능, Child-method3()
    }
}
