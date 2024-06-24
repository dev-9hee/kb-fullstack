package baekjoon;

import java.util.Scanner;

// 상현이가 가르치는 아이폰 앱 개발 수업의 수강생은 원섭, 세희, 상근, 숭, 강수
// 어제 이 수업의 기말고사가 있었고, 상현이는 지금 학생들의 기말고사 시험지를 채점하고 있다.
// 기말고사 점수가 40점 이상인 학생들은 그 점수 그대로 자신의 성적이 된다.
// 하지만, 40점 미만인 학생들은 보충학습을 듣는 조건을 수락하면 40점을 받게 된다.
// 보충학습은 거부할 수 없기 때문에, 40점 미만인 학생들은 항상 40점을 받게 된다.
// 학생 5명의 점수가 주어졌을 때, 평균 점수를 구하는 프로그램을 작성
public class Test10039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 학생 5명의 점수 입력 받기
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        int[] scores = new int[] {a, b, c, d, e};
        int[] finalScore = new int[scores.length];

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            if (score >= 40) {
                finalScore[i] = score;
            } else {
                finalScore[i] = 40;
            }
        }

        int sum = 0;
        int avg = 0;

        for (int i = 0; i < finalScore.length; i++) {
            sum += finalScore[i];
        }
        avg = sum / finalScore.length;

        System.out.println(avg);
    }
}
