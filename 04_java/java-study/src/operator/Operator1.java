package operator;

// 산술 연산자
public class Operator1 {
    public static void main(String[] args) {
        // 변수 초기화
        int a = 5;
        int b = 2;

        // 덧셈
        int sum = a + b;
        System.out.println("a + b = " + sum); // 출력 a + b = 7

        // 뺄셈
        int diff = a - b;
        System.out.println("a - b = " + diff); // 출력 a - b = 3

        // 곱셈
        int multi = a * b;
        System.out.println("a * b = " + multi); // 출력 a * b = 10

        // 나눗셈, 0으로 나눌 수 없음(오류 발생)
        // 같은 int 형끼리 계산하면 계산 결과도 같은 int 형 사용
        // int 형은 정수이기 때문에 소수점 이하를 포함할 수 없음
        int div = a / b;
        System.out.println("a / b = " + div); // 출력 a / b = 2

        // 나머지
        int mod = a % b;
        System.out.println("a % b = " + mod); // 출력 a % b = 1
    }
}
