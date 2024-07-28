package codingtest.week1.예산;

import java.util.*;

// Lv.1 : 그리디, 정렬
// 문제3) 예산
// 강사님 풀이, 심화
// 일반적으로 메소드의 파라미터를 직접 변화시키는 것은 좋지 않다. 따라서 아래와 같이 개선할 수 있다!!
public class Solution2 {
    public int solution(int[] d, int budget) {
        int budgetCopy = budget;
        // ... budget 대신 budgetCopy 사용..!

        //✅ d를 정렬한다.
        Arrays.sort(d);
        int result = 0;

        //✅ 예산이 적은 부서부터 전체 예산이 소진될 때까지 지급한다.
        for (int price : d) {
            budgetCopy -= price;
            if (budgetCopy < 0) break;
            result++;
        }

        //✅ 예산을 지급한 부서의 개수를 반환한다.
        return result;
    }

    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        Solution2 sol = new Solution2();
        int result = sol.solution(d, 9);
        System.out.println(result);
    }
}
