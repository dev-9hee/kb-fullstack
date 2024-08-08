package codingtest.week5.게임맵최단거리;

import java.util.*;

// [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]
public class Solution {
    public int solution(int[][] maps) {
        int n = maps.length; // 맵의 행 수
        int m = maps[0].length; // 맵의 열 수
        boolean[][] visited = new boolean[n][m]; // 각 위치의 방문 여부를 저장하는 2차원 배열
        Queue<int[]> queue = new ArrayDeque<>(); // BFS 탐색을 위한 큐. 각 원소는 [row, column, distance] 형태

        //✅ BFS 탐색을 수행한다.
        // BFS 초기화
        queue.add(new int[]{0, 0, 1}); // 시작점 (0, 0)을 큐에 추가하고, 초기 거리를 1로 설정
        visited[0][0] = true; // 시작점을 방문했다고 표시

        // 좌하우상 네 방향으로 이동하기 위한 방향 벡터
        int[] dr = {-1, 1, 0, 0}; // dr은 행(row)의 변화량
        int[] dc = {0, 0, -1, 1}; // dc는 열(column)의 변화량

        while (!queue.isEmpty()) { // 큐가 빌 때까지 반복
            int[] cur = queue.remove(); // 큐에서 현재 위치를 꺼내고
            int r = cur[0], c = cur[1], dist = cur[2]; // cur 에 저장된 값을 분리.. row, column, distance

            //✅ 탐색 과정에서 목적지에 도달하면 거리를 반환한다.
            // 현재 위치가 목적지인 (n-1, m-1)인 경우, 현재까지의 거리를 반환
            if (r == n - 1 && c == m - 1) {
                return dist;
            }

            // 네 방향으로 이동을 시도
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];

                // 이동한 위치가 지도 내에 있고, 이동 가능한 위치이며, 방문하지 않은 위치인 경우
                if (0 <= nr && nr < n && 0 <= nc && nc < m && maps[nr][nc] == 1 && !visited[nr][nc]) {
                    // 그 위치를 방문했다고 표시하고 큐에 추가하며 거리를 1 증가
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc, dist + 1});
                }
            }
        }

        //✅ 탐색 과정에서 목적지에 도달하지 못했다면 -1을 반환한다.
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
        System.out.println(result);
    }
}
