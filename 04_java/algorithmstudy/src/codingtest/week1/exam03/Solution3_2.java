package week1.exam03;

import java.util.*;

// Lv.1 : 그리디, 정렬
// 문제3) 예산
// 강사님 풀이
public class Solution3_2 {
    public int solution(int[] d, int budget) {
        //✅ d를 정렬한다.
        Arrays.sort(d);
        int result = 0;

        //✅ 예산이 적은 부서부터 전체 예산이 소진될 때까지 지급한다.
        for (int price : d) {
            budget -= price;
            if (budget < 0) break;
            result++;
        }

        //✅ 예산을 지급한 부서의 개수를 반환한다.
        return result;
    }

    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        Solution3 sol = new Solution3();
        int result = sol.solution(d, 9);
        System.out.println(result);
    }
}
