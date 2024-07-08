package afternoon.generic.method;

public class GenericQuiz1<T> {
    // 1번 : 문제 없음, 클래스가 인스턴스화 될 떼 생성됨
    public T quiz1(T t) { return t; }

    // 2번 : 문제 생김, static 메소드는 JVM 이 처음에 코드를 읽을 때 생성됨
//    public static T quiz2(T t) { return t; }
}
