package loop;

// 새로운 문제: i부터 하나씩 증가하는 수를 endNum(마지막 수)까지 더해라 (i ~ endNum 더하기)
public class While2_3 {

    public static void main(String[] args) {
        int sum = 0;
        int i = 1;
        int endNum = 3;

        while (i <= endNum) {
            sum += i; // sum = sum + 1
            System.out.println("i=" + i + " sum=" + sum);
            i++;
        }
    }
}
