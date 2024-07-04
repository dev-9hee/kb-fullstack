package beforenoon.ch16.sec03;

// 문제5) 다음과 같이 인터페이스와 클래스를 정의하세요.
// 람다를 구성할 때는 들어갈 인터페이스가 뭔지가 제일 중요함!
public class Person {
    public void action1(Workable workable) {
        workable.work("정지희", "프로그래밍");
    }

    public void action2(Speakable speakable) {
        speakable.speak("안녕하세요!!");
    }
}
