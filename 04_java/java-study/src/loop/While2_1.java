package loop;

// 일단 while 문 사용하지 않고 풀어보기, 변경에 유연하지 않다.
public class While2_1 {

    public static void main(String[] args) {
        int sum = 0;

        sum = sum + 1;
        System.out.println("i=" + 1 + " sum=" + sum);

        sum = sum + 2;
        System.out.println("i=" + 2 + " sum=" + sum);

        sum = sum + 3;
        System.out.println("i=" + 3 + " sum=" + sum);
    }
}
