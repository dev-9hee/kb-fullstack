package beforenoon.ch16.sec04;

// 문제7) 다음과 같이 Calculable 인터페이스와 Person 클래스를 정의하세요.
// 함수형 인터페이스의 추상 메소드에 리턴값이 있을 경우 람다식 작성
// return 문 하나만 있을 경우에는 중괄호와 함께 return 키워드를 생략 가능
// 리턴값은 연산식 또는 리턴값 있는 메소드 호출로 대체 가능
@FunctionalInterface
public interface Calculable {
    double calc(double x, double y);
}
