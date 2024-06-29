package loop;

// 문제: 1부터 시작해서 숫자를 계속 누적해서 더하다가 합계가 10보다 처음으로 큰 값은 얼마인가?
public class Break1 {

    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        while(true) { // 무한반복
            sum += i; // sum = sum + i
            if (sum > 10) {
                System.out.println("합이 10보다 크면 종료: i=" + i + " sum=" + sum);
                break; // break 는 반복문을 즉시 종료
            }
            i++;
        }
    }
}
