package codingtest.week3.ex.ex01;

// 수업교재에 있는 순열 코드 참고하면 쉽게 가능!
// Lv.2 : 완전탐색
// 문제1 : 피로도
// 최소 필요 피로도 : 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
// 소모 피로도 : 던전을 탐험한 후 소모되는 피로도
// k : 현재 피로도 / dungeons[][] : "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열
public class Solution {
    int answer = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] dungeons = {{80,20}, {50, 40}, {30, 10}};
        int result = solution.solution(80, dungeons);
        System.out.println(result);
    }

    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        backtrack(k, visited, n, dungeons, 0);
        return answer;
    }

    public void backtrack(int cur_k, boolean[] visited, int n, int[][] dungeons, int cnt) {
        // base case
        if (cnt > answer) { // 경우의 수가 더 많으면 answer 값을 cnt
            answer = cnt;
        }
        // recursive call
        for (int i = 0; i < n; i++) {
            if (cur_k >= dungeons[i][0] && !visited[i]) { // 현재 피로도가 최소 피로도보다 크고, 방문하지 않았어야 실행
                visited[i] = true;
                backtrack(cur_k - dungeons[i][1], visited, n, dungeons, cnt+1);
                visited[i] = false;
            }
        }
    }
}
