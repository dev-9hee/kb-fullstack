package beforenoon.ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        // 자식 객체 생성
        Child child = new Child();

        // 자동 타입 변환
        Parent parent = child;

        // 메소드 호출
        parent.method1();
        parent.method2(); // 오버라이딩 된 메소드 사용 가능!!
//        parent.method3(); // 호출 불가능
    }
}
