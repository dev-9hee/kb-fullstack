package codingtest.week3.study;

import java.util.*;

// 순열
public class Permutation {
    public static void main(String[] args) {
        Permutation p = new Permutation();
        int[] num = { 1, 2, 3 };
        List<List<Integer>> result = p.permute(num);
        System.out.println(p.permute(new int[] { 1, 2, 3 }));
    }

    public List<List<Integer>> permute(int[] nums) {
        // List 의 리턴 값 List<Integer>
        List<List<Integer>> ans = new ArrayList<>();
        // 방문 기록하는 boolean 값으로 저장하는 visited 배열, 방문하면 true, 방문하지 안았으면 false
        boolean[] visited = new boolean[nums.length]; // nums 배열의 길이만큼 크기를 정함
        backtrack(new ArrayList<>(), nums, visited, ans);
        return ans;
    }
    // 순열을 만들어서 ans 에 추가하는 함수
    // List<Integer> curr : 현재 정보를 담을 배열
    private void backtrack(List<Integer> curr, int[] nums, boolean[] visited, List<List<Integer>> ans) {
        // base case
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr)); // 새로운 배열 만들어서 ans 에 추가
            return;
        }
        // recursive call
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            curr.add(nums[i]);
            visited[i] = true;
            backtrack(curr, nums, visited, ans);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}
