package codingtest.week6.가장먼노드;

import java.util.*;

// n : 노드의 개수
// edge[][] : 간선에 대한 정보가 담긴 2차원 배열
public class Test {
    public int solution(int n, int[][] edge) {
        // 그래프 표현
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>()); // 노드, 해당 노드의 인접 노드 리스트
        }

        // 그래프 구축
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // bfs 초기화
        boolean[] visited = new boolean[n+1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;

        // bfs 탐색
        int maxDist = 0, count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();

            // 각 노드 처리
            if (maxDist < cur[1]) {
                maxDist = cur[1];
                count = 1;
            } else if (maxDist == cur[1]) {
                count++;
            }

            // 인접 노드를 큐에 추가
            for (int next : graph.get(cur[0])) {
                if (visited[next]) continue; // 이미 방문

                visited[next] = true;
                queue.add(new int[]{next, cur[1] + 1});
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Test sol = new Test();
        int result = sol.solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        System.out.println(result);
    }
}
