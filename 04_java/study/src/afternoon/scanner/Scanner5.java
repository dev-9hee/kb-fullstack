package afternoon.scanner;

import java.util.Scanner;

public class Scanner5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { // 무한 루프 구현
            System.out.print("문자열을 입력하세요.(종료를 원하시면 exit 입력) : ");
            String str = scanner.nextLine(); // 문자열로 입력 받기
            if(str.equals("exit")){ // exit가 입력되면 break로 while 반복문 종료
                System.out.println("프로그램 종료!!");
                break;
            }
            System.out.println("입력한 문자열 : " + str); // exit가 아니면 입력한 문자열을 출력
        }
    }
}
