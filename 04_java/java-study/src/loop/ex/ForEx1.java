package loop.ex;

// 문제: 자연수 출력
// 처음 10개의 자연수를 출력하는 프로그램을 작성.. 이때, count 라는 변수를 사용해야 합니다.
// while 문, for 문 2가지 버전의 정답
public class ForEx1 {

    public static void main(String[] args) {

        // for 문 사용
        for (int count = 1; count <= 10; count++) {
            System.out.println(count);
        }
    }
}
