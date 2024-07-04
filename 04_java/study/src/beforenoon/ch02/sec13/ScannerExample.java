package beforenoon.ch02.sec13;

import java.util.Scanner;

public class ScannerExample {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         System.out.print("x 값 입력: ");
         String strX = scanner.nextLine(); // next() : 단어, nextLine() : 문장 입력 받음
         int x = Integer.parseInt(strX); // 문자열로 입력 받은 걸 정수로 변환

         System.out.print("y 값 입력: ");
         String strY = scanner.nextLine();
         int y = Integer.parseInt(strY);

         int result = x + y;
         System.out.println("x + y: " + result);
         System.out.println(); // 빈 문자열 출력

         while(true) {
             System.out.print("입력 문자열: ");
             String data = scanner.nextLine();
             if(data.equals("q")) { // q를 입력하면 반복문 빠져나옴
                 break;
             }
             System.out.println("출력 문자열: " + data);
             System.out.println();
         }

         System.out.println("종료");
     }
}
