package study.recursion;

public class Recursion1 {
    public static void main(String[] args) {
        int number = 5;
        int result = factorial(number);
        System.out.println(" = Factorial result : " + result);
    }

    private static int factorial(int n) {
        if (n == 1) {
            System.out.print(n);
            return 1;
        }
        System.out.print(n + " * ");
        return n * factorial(n - 1);
    }
}

/* 예상 실행 결과
factorial(5) => 출력 : 5 * / 리턴값 5 * factorial(4)
factorial(4) => 출력 : 4 * / 리턴값 4 * factorial(3)
factorial(3) => 출력 : 3 * / 리턴값 3 * factorial(2)
factorial(2) => 출력 : 2 * / 리턴값 2 * factorial(1)
factorial(1) => 출력 : 1 / 리턴값 1
result = 5 * 4 * 3 * 2 * 1 = 120
*/
