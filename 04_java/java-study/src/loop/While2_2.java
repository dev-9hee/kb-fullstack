package loop;

// while 문 사용
// 문제: i부터 하나씩 증가하는 수를 3번 더해라 (i ~ i+2더하기)
public class While2_2 {

    public static void main(String[] args) {
        int sum = 0;
        int i = 1;

        sum = sum + i;
        System.out.println("i=" + i + " sum=" + sum);
        i++; // 2

        sum = sum + i;
        System.out.println("i=" + i + " sum=" + sum);
        i++; // 3

        sum = sum + i;
        System.out.println("i=" + i + " sum=" + sum);
    }
}
