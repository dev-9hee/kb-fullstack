package ch04.sec05;

import java.util.Scanner; // Scanner 객체를 사용하기 위해 필요

public class KeyControlExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 키보드와 Scanner 연결
        boolean run = true; // while 루프 종료 조건 변수
        int speed = 0;

        while(run) {
            System.out.println("------------------------------");
            System.out.println("1. 증속 | 2. 감속 | 3. 중지");
            System.out.println("------------------------------");
            System.out.print("선택: ");

            String strNum = scanner.nextLine(); // 키보드에서 입력한 내용을 읽음(문자열)

            if(strNum.equals("1")) {
                speed++;
                System.out.println("현재 속도 = " + speed);
            } else if(strNum.equals("2")) {
                speed--;
                System.out.println("현재 속도 = " + speed);
            } else if(strNum.equals("3")) {
                run = false; // while문의 조건식을 false로
            }
        }
        System.out.println("프로그램 종료");
    }
}
