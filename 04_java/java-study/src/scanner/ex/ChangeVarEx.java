package scanner.ex;

// 문제 - 변수 값 교환
// 변수 a=10 이 들어있고, b=20 이 들어있다.
// 변수 a 의 값과 변수 b 의 값을 서로 바꾸어라
// 다음 코드에서 시작과 종료 부분 사이에 변수의 값을 교환하는 코드를 작성하면 된다.
// 힌트: temp 변수를 활용해야 한다
// 예시 >
// a = 20
// b = 10
public class ChangeVarEx {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int temp;

        temp = a; // temp = 10
        a = b; // a = 20
        b = temp; // b = 10

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
