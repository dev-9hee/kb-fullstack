package beforenoon.ch16.sec04;

// 문제7) 다음과 같이 Calculable 인터페이스와 Person 클래스를 정의하세요.
public class Person {
    public void action(Calculable calculable) {
        double result = calculable.calc(10, 4);
        System.out.println("결과 : " + result);
    }
}
