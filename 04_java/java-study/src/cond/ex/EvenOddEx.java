package cond.ex;

// 문제 : 홀수 짝수 찾기
// 정수 x 가 주어지면 x 가 짝수이면 "짝수"를, x 가 홀수이면 "홀수"를 출력하는 프로그램을 작성
// 삼항 연산자 사용
// 출력 예신 : x: 2 => 출력: x = 2, 짝수
public class EvenOddEx {

    public static void main(String[] args) {
        int x = 2;

        String result = (x % 2 == 0) ? "짝수" : "홀수";
        System.out.println("x = " + x + ", " + result);

//        if ( x % 2 == 0 ) {
//            System.out.println("x = " + x + ", 짝수");
//        } else {
//            System.out.println("x = " + x + ", 홀수");
//        }
    }
}
