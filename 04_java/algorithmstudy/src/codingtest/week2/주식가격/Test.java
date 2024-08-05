package codingtest.week2.주식가격;

import java.util.*;

public class Test {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length]; // 각 시점의 주식 가격이 떨어지지 않은 기간을 저장, 리턴할 값
        Deque<Integer> stack = new ArrayDeque<>(); // 각 시점의 인덱스를 저장, 이 스택을 이용해 가격이 떨어지는 시점을 효율적으로 찾음

        // 주식 가격 순회, 주식 가격 배열을 순회하며 각 시점을 처리
        for (int i = 0; i < prices.length; i++) {
            // 스택이 빌 때까지 반복
            while (!stack.isEmpty()) {
                int j = stack.peek(); // 스택의 맨 위의 값을 단순히 반환
                // 스택의 맨 위 인덱스의 가격이 현재 가격보다 큰지 확인
                // 현재 시점의 가격 prices[i]가 이전 시점의 가격보다 낮으면 그 이전 시점의 가격이 떨어지기 전까지의 기간을 계산해 answer 배열에 저장
                if (prices[j] > prices[i]) {
                    // 인덱스간 차이를 저장하고, 스택 맨 위 인덱스를 제거
                    answer[j] = i - j;
                    // stack 은 아직 가격이 떨어지지 않은 시점들의 인덱스를 유지
                    stack.pop();
                }
                // 아니라면 빠져나옴
                else break;
            }
            stack.push(i);
        }

        // for 문을 다 돌고 스택에 남은 인덱스들에 대해 기간을 계산하여 저장
        // 끝까지 가격이 떨어지지 않은 시점들
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices.length - idx - 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Test solution = new Test();
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
