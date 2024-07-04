package beforenoon.ch16.sec02.exam01;

// 문제3) 다음과 같이 Workable 인터페이스와 Person 클래스를 정의하세요.
public class Person {
    public void action(Workable workable) {
        workable.work();
    }
}
