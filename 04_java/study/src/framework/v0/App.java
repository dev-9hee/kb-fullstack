package framework.v0;

import java.util.Scanner;

// 문제점 : 단일 책임의 원칙 위반
public class App {
    public static void main(String[] args) {
        boolean run = true;
        int studentNum = 0;
        int[] scores = null;

        Scanner sc = new Scanner(System.in); // 입력 받을거야

        while(run) {
            System.out.println("------------------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("-------------------------------------------------------");
            System.out.print("선택> ");

            int selectNo = Integer.parseInt(sc.nextLine()); // 첫번째 입력을 int 형으로 받음
            if(selectNo == 1) { // 학생 수 입력 선택
                System.out.print("학생수> ");
                studentNum = Integer.parseInt(sc.nextLine()); // 학생 수 입력 받음
                scores = new int[studentNum]; // 학생 수 크기의 scores 배열을 생성
            } else if (selectNo == 2) { // 점수 입력 선택
                for (int i = 0; i < scores.length; i++) {
                    System.out.print("scores[" + i + "]> ");
                    scores[i] = Integer.parseInt(sc.nextLine());
                }
            } else if (selectNo == 3) { // 점수 리스트 선택
                for (int i = 0; i < scores.length; i++) {
                    System.out.println("scores[" + i + "]: " + scores[i]);
                }
            } else if (selectNo == 4) {
                int max = 0;
                int sum = 0;
                double avg = 0;
                for (int i = 0; i < scores.length; i++) {
                    max = (max<scores[i]) ? scores[i] : max;
                    sum += scores[i];
                }
                avg = (double) sum / studentNum;
                System.out.println("최고 점수: " + max);
                System.out.println("평균 점수: " + avg);
            } else if (selectNo == 5) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }
}
