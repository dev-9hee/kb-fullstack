package beforenoon.ch16.sec03;

// 문제5) 다음과 같이 인터페이스와 클래스를 정의하세요.
@FunctionalInterface
public interface Workable {
    void work(String name, String job); // 매개변수 있음
}
