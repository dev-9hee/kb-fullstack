package afternoon.scanner;

import java.util.Scanner;

public class Scanner6Ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int randNum = (int) (Math.random()*100); // 0~99 사이의 랜덤 숫자 생성
        System.out.println(randNum); // 랜덤 숫자 확인



        while(true) {
            System.out.print("랜덤 숫자를 입력하세요 : ");
            int num = scanner.nextInt();

            if (randNum > num) {
                System.out.println("Up");
            }else if (randNum < num) {
                System.out.println("Down");
            }else {
                System.out.println("정답입니다! 랜덤 숫자는 " + randNum);
                break;
            }
        }
    }
}
