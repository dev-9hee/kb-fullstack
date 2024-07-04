package beforenoon.ch16.sec02.exam01;

// 문제4) 앞에서 정의한 인터페이스와 클래스를 이용하여 아래 코드를 완성하세요.
// 매개변수가 없는 람다식 : 함수형 인터페이스의 추상 메소드에 매개변수가 없을 경우 람다식 작성
// 실행문이 두 개 이상일 경우에는 중괄호를 생략할 수 없고, 하나일 경우에만 생략 가능
public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 실행문이 두 개 이상인 경우 중괄호 필요
        person.action(() -> {
            System.out.println("출근을 합니다.");
            System.out.println("프로그래밍을 합니다.");
        });

        // 실행문이 한 개일 경우 중괄호 생략 가능
        person.action(() -> System.out.println("퇴근합니다."));
    }
}
