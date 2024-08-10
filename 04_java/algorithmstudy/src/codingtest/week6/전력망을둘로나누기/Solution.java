package codingtest.week6.전력망을둘로나누기;

import java.util.*;

public class Solution {
    int answer; // 노드 수 차이의 최소값을 저장
    public int solution(int n, int[][] wires) { // n : 송전탑의 개수, wires : 전선 정보
        answer = n; // 처음엔 송전탑의 개수 n으로 초기화
        // 주어진 엣지 데이터를 사용하기 쉽게 가공
        // 그래프 구현
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        // 그래프 표현
        for (int[] w : wires) {
            graph.get(w[0]).add(w[1]);
            graph.get(w[1]).add(w[0]);
        }

        // dfs 탐색
        boolean[] visited = new boolean[n+1];
        dfs(graph, visited, 1, n); // 시작 노드를 1로 설정하고 dfs 탐색을 시작

        return answer;
    }

    public int dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int cur, int n) {
        int count = 1; // 현재 노드를 포함한 서브트리의 노드 수, 1로 초기화
        visited[cur] = true; // 현재 노드 방문 표시

        // 인접 노드 탐색
        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                // 아직 방문하지 않은 노드에 대해 재귀적으로 dfs 를 호출하고,
                // 해당 노드에서 반환된 서브트리의 노드 수를 count 에 더함
                count += dfs(graph, visited, next, n);
            }
        }

        // 최적값 업데이트
        // 전선 하나를 제거했을 때 두 전력망으로 나뉘는 상황에서 각 부분의 노드 수 차이를 의미
         answer = Math.min(answer, Math.abs(n - count * 2));

        // 자신 아래의 노드 수를 재귀적으로 반환
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}});
        System.out.println(result);
    }
}
