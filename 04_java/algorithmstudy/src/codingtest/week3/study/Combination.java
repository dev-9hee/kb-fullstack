package codingtest.week3.study;

import java.util.*;

// 조합
public class Combination {
    public static void main(String[] args) {
        Combination c = new Combination(); // 클래스를 인스턴스화
        Scanner input = new Scanner(System.in);
        System.out.print("n 입력 : ");
        int n = input.nextInt(); // n 입력받음
        System.out.print("k 입력 : ");
        int k = input.nextInt(); // k 입력받음
        List<List<Integer>> result = c.combine(n, k); // 리스트 받아옴
        System.out.println(result);
    }

    public List<List<Integer>> combine(int n, int k) {
        // 모든 조합을 찾고 List<List<Integer>> 형태로 반환
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, new ArrayList<>(), n, k, ans); // backtrack 메서드를 호출하여 백트래킹을 시작
        return ans;
    }

    private void backtrack(int start, List<Integer> curr, int n, int k, List<List<Integer>> ans) {
        // base case
        if (curr.size() == k) {
            // curr 리스트의 현재 상태를 복사하여 저장
            ans.add(new ArrayList<>(curr)); // 현재 조합을 결과 리스트에 추가
            return;
        }
        // recursive call
        for (int i = start; i <= n; i++) { // start 부터 n 까지의 숫자를 반복
            curr.add(i); // 현재 숫자를 조합에 추가
            backtrack(i + 1 , curr, n, k, ans); // 다음 숫자로 재귀 호출
            curr.remove(curr.size() - 1); // 백트래킹을 위해 마지막 숫자 제거
        }
    }
}
