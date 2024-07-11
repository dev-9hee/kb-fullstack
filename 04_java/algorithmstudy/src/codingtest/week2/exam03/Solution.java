package codingtest.week2.exam03;

import java.util.*;

// Lv.2 : 스택
// 문제3) 주식가격
// 강사님 풀이, Deque stack 사용
public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();

        //✅ 모든 인덱스를 순회한다.
        for (int i = 0; i < prices.length; i++) {
            //✅ 스택이 빌 때까지 반복한다.
            while (!stack.isEmpty()) {
                int j = stack.peek(); // 스택의 맨 위에 있는 값을 제거하지 않고 단순히 반환
                //✅ 스택의 맨 위 인덱스의 가격이 현재 가격보다 큰지 확인한다.
                if (prices[j] > prices[i]) {
                    //✅ 인덱스간 차이를 저장하고, 스택 맨 위 인덱스를 제거한다.
                    answer[j] = i - j;
                    stack.pop();
                }
                //✅ 아니라면 빠져나온다.
                else break;
            }

            stack.push(i);
        }

        //✅ 스택에 남은 인덱스들에 대해 기간을 계산하여 저장한다.
        while (!stack.isEmpty()) {
            int i = stack.pop();
            answer[i] = prices.length - i - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new int[]{1, 2, 3, 2, 3});
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            if ( i == result.length - 1 ) {
                System.out.print(result[i]);
            } else {
                System.out.print(result[i] + ",");
            }
        }
        System.out.println("]");
    }
}
