package operator.ex;

// 문제3 - 합격 범위
public class OperationEx3 {

    public static void main(String[] args) {
        int score = 80;

        // score 가 80점 이상이고, 100점 이하이면 true 를 출력하고, 아니면 false 를 출력
        boolean result = 80 <= score && score <= 100; // true or false 반환
        System.out.println(result); // true
    }
}
