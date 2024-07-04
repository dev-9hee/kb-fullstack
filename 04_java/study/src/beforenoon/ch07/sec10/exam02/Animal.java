package beforenoon.ch07.sec10.exam02;

public abstract class Animal {
    // 메소드 선언
    public void breathe() {
        System.out.println("숨을 쉽니다.");
    }

    // 추상 메소드 선언
    public abstract void sound(); // 메소드 실행 내용인 중괄호가 없음
}
