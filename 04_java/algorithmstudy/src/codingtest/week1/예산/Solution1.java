package codingtest.week1.예산;

import java.util.Arrays;

// Lv.1 : 그리디, 정렬
// 문제3) 예산
// 그리디 알고리즘 적용 : 탐욕 알고리즘, 문제를 해결하기 위해 각 단계에서 가장 최선의 선택(즉, 현재 상태에서 가장 좋다고 생각되는 선택)을 하는 알고리즘
public class Solution1 {
    public int solution(int[] d, int budget) {
        // d를 정렬한다.
        Arrays.sort(d); // 배열 정렬

        int count = 0; // 지원할 수 있는 부서의 수 카운트

        // 예산이 적은 부서부터 전체 예산이 소진될 때까지 지급한다.
        for (int price : d) { // 정렬된 배열에 있는 값들을 하나씩 for 문 돌림
            budget -= price; // 예산에서 각 가격을 마이너스
            if (budget < 0) break; // 예산보다 작아지면 빠져나옴
            count++;
        }
        // 예산을 지급한 부서의 개수를 반환한다.
        return count;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int result = solution.solution(new int[] {1,3,2,5,4}, 9);
        System.out.println(result);
    }
}

/* 문제 분석
각 부서가 신청한 금액만큼을 모두 지원해줘야 함
배열 d[] : 부서별로 신청한 금액이 들어있는 배열
변수 budget : 예산
=> 최대 몇 개의 부서에 물품을 지원할 수 있는지 리턴 (지원할 수 있는 부서의 수)
*/
