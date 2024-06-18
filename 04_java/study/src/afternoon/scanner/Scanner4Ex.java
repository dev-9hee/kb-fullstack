package afternoon.scanner;

import java.util.Scanner;

public class Scanner4Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("시작 정수를 입력하세요 : ");
        int num1 = scanner.nextInt();

        System.out.print("종료 정수를 입력하세요 : ");
        int num2 = scanner.nextInt();

//        // 내 풀이
//        int sum = 0;
//        if (num1 <= num2) {
//            for (int i = num1; i <= num2; i++) {
//                sum += i;
//            }
//            System.out.println("시작 수 부터 종료 수 까지의 합은 : " + sum);
//        } else {
//            System.out.println("시작 정수가 종료 정수 보다 큽니다!");
//        }

        // 다른 풀이
        if(num1 > num2) {
            System.out.println("시작 정수가 종료 정수 보다 큽니다!");
            return;
        }
        int sum = 0;
        for(int i = num1; i <= num2; i++) {
            sum += i;
        }
        System.out.println("시작 수 부터 종료 수 까지의 합은 : " + sum);
    }
}
