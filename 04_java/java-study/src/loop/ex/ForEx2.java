package loop.ex;

// 문제: 짝수 출력
// 반복문을 사용하여 처음 10개의 짝수를 출력하는 프로그램을 작성.. 이때, num 이라는 변수를 사용하여 수를 표현
// while 문, for 문 2가지 버전의 정답
public class ForEx2 {

    public static void main(String[] args) {
        // for 문 사용
        for (int num = 2, count = 1; count <= 10; num += 2, count++) {
            System.out.println(num);
        }

//        for (int num=1; num<=20; num++) {
//            if (num%2==0) {
//                System.out.println(num);
//            }
//        }
    }
}
