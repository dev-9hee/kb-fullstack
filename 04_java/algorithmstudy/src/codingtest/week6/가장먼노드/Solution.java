package codingtest.week6.가장먼노드;

import java.util.*;

// n : 노드의 개수
// edge[][] : 간선에 대한 정보가 담긴 2차원 배열
// 	edge => [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]
public class Solution {
    public int solution(int n, int[][] edge) {
        //✅ 주어진 엣지 데이터를 사용하기 쉽게 가공한다.

        // 그래프 표현
        // Map 을 사용하여 그래프를 표현, 키는 노드를 나타내고 값은 해당 노드의 인접 노드 리스트
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // 루프를 통해 각 노드에 빈 리스트를 초기화
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 그래프 구축
        // 각 간선을 순회하며 양쪽 노드를 서로의 인접 리스트에 추가하여 무방향 그래프를 구축
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // BFS 초기화
        boolean[] visited = new boolean[n+1]; // 노드 방문 여부를 추적하여 중복 작업을 방지
        Queue<int[]> queue = new ArrayDeque<>(); // 너비 우선 탐색(BFS)을 위해 사용
        queue.add(new int[]{1, 0}); // 노드 1을 거리 0으로 시작
        visited[1] = true; // 노드 1을 방문한 것으로 표시

        //✅ BFS 탐색을 수행하며 정답을 업데이트한다.

        // maxDist 는 발견된 최대 거리를 추적, count 는 maxDist 에 있는 노드의 개수를 세기 위한 변수
        int maxDist = 0, count = 0;
        while (!queue.isEmpty()) { // BFS 루프는 큐가 비어 있을 때까지 계속
            int[] cur = queue.remove(); // 처리 중인 각 노드(cur)

            // 각 노드 처리
            // cur[0]은 노드 번호, cur[1]은 시작 노드로부터의 거리
            if (maxDist < cur[1]) { // 현재 거리가 maxDist 보다 크면 maxDist 를 갱신하고 count 를 초기화
                maxDist = cur[1];
                count = 1;
            } else if (maxDist == cur[1]) { // 현재 거리가 maxDist 와 같으면 count 를 증가
                count++;
            }

            // 인접 노드를 큐에 추가
            for (int next : graph.get(cur[0])) { // 현재 노드의 각 인접 노드(next)를 확인
                if (visited[next]) continue; // 방문했다면 다시 위로
                // 방문하지 않았다면 방문 표시를 하고 거리를 1 증가시켜 큐에 추가
                visited[next] = true;
                queue.add(new int[]{ next, cur[1] + 1});
            }
        }
        return count; // 시작 노드(노드 1)로부터 가장 멀리 떨어진 노드의 개수
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
        System.out.println(result);
    }
}
