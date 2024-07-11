package codingtest.week2.exam01;
import java.util.*;

// 내가 푼 풀이, 시간 초과
class Solution2 {
    public int solution(int[] queue1, int[] queue2) { // 길이가 같은 두 개의 큐 배열

        // 양쪽 끝에서 삽입, 삭제가 가능
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        int n = queue1.length;
        int count = 0; // 작업의 횟수 구하는 변수, 빼서 넣는 작업을 1회 수행한 것으로 간주

        // 일단 받은 배열을 큐에 삽입
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]); // offer 로 해주는게 좋음 (예외처리를 해 줌)
            q2.add(queue2[i]);
        }

        long sum1 = sum(q1); // q1에 저장된 값의 합
        long sum2 = sum(q2); // q2에 저장된 값의 합

        for (int i = 0; i<4*n; i++) {
            if (sum1 > sum2) {
                if (q1.isEmpty()) return -1;
                q2.add(q1.remove());
                count++;
            } else if (sum1 < sum2) {
                if (q2.isEmpty()) return -1;
                q1.add(q2.remove());
                count++;
            }
            else {
                return count;
            }
            sum1 = sum(q1);
            sum2 = sum(q2);
        }
        return -1;
    }

    public static int sum(Queue<Integer> q) {
        int sum = 0;
        for (int num : q) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int result = solution.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
        System.out.println(result);
    }
}