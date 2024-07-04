package beforenoon.ch16.sec03;

// 문제6) 앞에서 정의한 인터페이스와 클래스를 이용하여 아래 코드를 완성하세요.
// 매개변수가 있는 람다식
// 매개변수가 하나일 경우에는 괄호 생략 가능, 이때는 타입 또는 var 을 붙일 수 없음
public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 매개변수가 두 개일 경우
        person.action1((name, job) -> {
            System.out.print(name + "가 ");
            System.out.println(job + "을 합니다.");
        });
        person.action1((name, job) -> System.out.println(name + "가 " + job + "을 하지 않습니다."));

        // 매개변수가 한 개일 경우
        person.action2(word -> {
            System.out.print("\"" + word + "\"");
            System.out.println("라고 말합니다.");
        });
        person.action2(word -> System.out.println("\"" + word + "\"라고 외칩니다."));
    }
}
