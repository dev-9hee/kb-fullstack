package codingtest.week4.타겟넘버;

import java.util.*;

public class Solution {
    public int solution(int[] numbers, int target) {
        // DFS 탐색을 통해 합이 target 이 되는 경우의 수를 구함
        // numbers: 숫자 배열
        // index: 현재 탐색 중인 배열의 인덱스
        // target: 목표로 하는 값
        // cur: 현재까지의 합
        return dfs(numbers, 0, target, 0); // cur : 현재값, 0
    }

    public int dfs(int[] numbers, int index, int target, int cur) {
        // base-case
        // index 가 배열의 길이와 같아지면, cur 값이 target 과 같은지 확인
        if (index == numbers.length) {
            return (cur == target) ? 1 : 0; // 같으면 1을 반환하고, 그렇지 않으면 0을 반환
        }
        // 재귀호출
        int sum = 0;
        // 2가지 경우의 수
        sum += dfs(numbers, index + 1, target, cur + numbers[index]); // 현재 인덱스의 숫자를 더한 경우 (cur + numbers[index])
        sum += dfs(numbers, index + 1, target, cur - numbers[index]); // 현재 인덱스의 숫자를 뺀 경우 (cur - numbers[index])

        return sum; // 이 값은 현재 경로에서 target 을 만들 수 있는 경우의 수
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[]{4, 1, 2, 1}, 4);
        System.out.println(result);
    }
}
