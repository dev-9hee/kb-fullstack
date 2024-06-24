package baekjoon;

import java.util.Scanner;

// 대회에서 상금을 받으면 전체 금액의 22%를 제세공과금으로 국가에 납부하고, 나머지 금액을 수령
// 하지만, 상금의 80%를 필요 경비로 인정하게 되면, 나머지 20% 중 22%만을 제세공과금으로 납부
public class Test20492 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int winner = sc.nextInt(); // 받은 상금

        int case1 = (int) (winner * 0.78);
        int case2 = (int) (winner * 0.8);
        int case3 = (int) ((winner * 0.2) * 0.78);
        int sum = case2 + case3;

        System.out.println(case1 + " " + sum);
    }
}
