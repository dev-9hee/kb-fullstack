package codingtest.week2.dailytempuratures;

import java.util.*;

// 일일 기온 문제
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int day= 0; day < temperatures.length; day++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[day]) {
                  int prevDay = stack.pop();
                  result[prevDay] = day - prevDay;
            }
            stack.push(day);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution study3 = new Solution();
        int[] ans = study3.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.print("[");
        for (int i = 0; i < ans.length; i++) {
            if ( i == ans.length - 1 ) {
                System.out.print(ans[i]);
            } else {
                System.out.print(ans[i] + ",");
            }
        }
        System.out.println("]");
    }
}
