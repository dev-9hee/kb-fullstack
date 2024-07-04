package beforenoon.ch16.sec01;

// 문제2) 앞의 Calculator 인터페이스를 이용해서, 다음 출력이 나오도록 다음 코드를 완성하세요.
// 단, 람다식을 이용
public class LambdaExample {
    public static void main(String[] args) {
        // x + y 계산
        action((x, y) -> {
            int result = x + y;
            System.out.println("result = " + result);
        });

        // x - y 계산
        action((x, y) -> {
            int result = x - y;
            System.out.println("result = " + result);
        });
    }

    public static void action(Calculable calculable) { // 다형성, 전략 패턴
        // 데이터
        int x = 10;
        int y = 4;
        // 데이터 처리
        calculable.calculate(x, y);
    }
}
