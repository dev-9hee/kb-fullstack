package codingtest.week1.exam03;

import java.util.*;

// Lv.1 : 그리디, 정렬
// 문제3) 예산
// 내 풀이
public class Solution3 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d); // 정렬

        int count = 0;

        for (int price : d) {
            budget -= price; // 예산에서 각 가격을 마이너스
            if (budget < 0) {break;} // 예산보다 작아지면 빠져나옴
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        Solution3 sol = new Solution3();
        int result = sol.solution(d, 9);
        System.out.println(result);
    }
}
