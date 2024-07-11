package codingtest.week2.exam01;

import java.util.*;

// 문제1) 두 큐 합 같게 만들기
// 강사님 풀이
public class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long q1Sum = 0;
        long q2Sum = 0;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        // 일단 받은 배열을 큐에 삽입하고 각 큐의 합 계산
        for (int value : queue1) {
            q1.add(value);
            q1Sum += value;
        }
        for (int value : queue2) {
            q2.add(value);
            q2Sum += value;
        }

        for (int i = 0; i < 4*n; i++) { // 무한루프가 되지 않도록 4n 정도 값을 줌
            if (q1Sum > q2Sum) {
                int value = q1.remove();
                q2.add(value); // offer 로 해주는게 좋음 (예외처리를 해 줌)
                q1Sum -= value;
                q2Sum += value;
            } else if (q1Sum < q2Sum) {
                int value = q2.remove();
                q1.add(value);
                q1Sum += value;
                q2Sum -= value;
            } else {
                return i;
            }
        }

        return -1; // 다 돌았는데 값이 같지 않으면 -1 리턴

        // 방법 2
//        int count = 0;
//
//        while (count < 4 * n) { // 무한루프가 되지 않도록 4n 정도 값을 줌
//            if (q1Sum > q2Sum) {
//                int value = q1.remove();
//                q2.add(value);
//                q1Sum -= value;
//                q2Sum += value;
//            } else if (q1Sum < q2Sum) {
//                int value = q2.remove();
//                q1.add(value);
//                q1Sum += value;
//                q2Sum -= value;
//            } else {
//                return count;
//            }
//            count++;
//        }
//
//        return -1; // 다 돌았는데 값이 같지 않으면 -1 리턴
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
        System.out.println(result);
    }
}
