package codingtest.week8.NetworkDelayTime;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 인풋을 본인이 쓰기 편한 구조로 바꾸기 => 방향 그래프 만들기
        // times 배열을 인접 리스트 형식으로 변환
        Map<Integer, List<int[]>> edges = Arrays.stream(times).collect(Collectors.groupingBy(t -> t[0]));
        int[] visited = new int[n+1]; // 각 노드까지의 최단 거리를 저장하는 배열, 노드 번호가 1부터 시작하는 경우
        Arrays.fill(visited, Integer.MAX_VALUE); // 배열의 모든 요소를 지정된 값으로 채움, 초기에는 모든 노드의 최단 거리를 무한대로 설정, MAX_VALUE = int 타입이 가질 수 있는 가장 큰 값
        // 우선순위 큐를 사용해 다익스트라 알고리즘을 구현
        // 큐에는 { 정점, 거리 } 형태의 배열이 들어간다.
        Queue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        // 시작 노드 k를 큐에 추가하고, 해당 노드까지의 거리는 0으로 설정
        pq.add(new int[]{k, 0}); // 시작노드 k, 해당 노드까지 거리 0
        visited[k] = 0; // 해당 노드까지의 최단 거리 0

        // k 로부터 모든 노드들의 최단거리 구하기 => 다익스트라 알고리즘 수행
        int maxTime = 0; // 모든 노드들까지의 최단 거리 중 최대값을 저장
        int visitCount = 1; // 방문한 노드의 수를 카운트, k는 방문했으니 초기값 1
        while (!pq.isEmpty()) { // 큐가 빌때까지 반복
            int[] cur = pq.remove(); // 현재 탐색 중인 노드의 번호, 시작 노드 k에서 노드 u 까지의 거리
            int u = cur[0], time = cur[1];
            if (visited[u] < time) continue; // 현재 노드 u 까지의 거리가 이미 더 짧은 경로로 방문된 적이 있다면 무시
            maxTime = time; // 현재까지 방문한 노드 중에서 가장 큰 최단 거리를 갱신
            // 현재까지 방문한 모든 노드 중에서 가장 큰 최단 거리를 추적 => 즉, 가장 먼 노드까지의 최단 거리를 나타냅니다.
            // maxTime 을 time 으로 갱신하는 것은 현재까지 도달한 노드 중 가장 큰 거리를 기록하는 것

            // 연결된 모든 간선에 대해 탐색
            if (!edges.containsKey(u)) continue; // 연결된 간선이 없으면 패스!
            for (int[] edge : edges.get(u)) {
                int v = edge[1], w = edge[2]; // 도착점, 거리
                // 이미 더 짧은 거리로 방문한 적이 있는 경우 패스!!
                if (time + w >= visited[v]) continue;

                // 처음 방문했다면 visitCount++
                if (visited[v] == Integer.MAX_VALUE) visitCount++;
                // 다익스트라가 수행되며 각 노드까지의 최단 거리 저장
                visited[v] = time + w;
                pq.add(new int[]{ v, time + w });
            }
        }
        // k 노드로 부터 도달할 수 없는 노드가 존재하는 경우 -1을 반환한다.
        // 그 외의 경우 저장된 최단 거리 중 최대값을 반환한다.
        return visitCount == n ? maxTime : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.networkDelayTime(new int[][] {{2,1,1},{2,3,1},{3,4,1}}, 4, 2);
        System.out.println(result);
    }
}
