package loop;

// 문제: 1부터 5까지 숫자를 출력하는데, 숫자가 3일 때는 출력을 건너뛰어야 한다.
// continue 는 반복문의 나머지 부분을 건너뛰고 다음 반복으로 진행하는데 사용
public class Continue1 {

    public static void main(String[] args) {
        int i = 1;

        while (i <= 5) {
            if (i == 3) {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
    }
}
