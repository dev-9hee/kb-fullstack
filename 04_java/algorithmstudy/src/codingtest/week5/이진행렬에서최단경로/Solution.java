package codingtest.week5.이진행렬에서최단경로;

import java.util.*;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // 초기값 세팅
        int rl = grid.length; // 행의 개수
        int cl = grid[0].length; // 열의 개수
        boolean[][] visited = new boolean[rl][cl]; // 방문 표시
        // 상하좌우, 대각선 총 8방향 방향벡터
        int[] dr = {-1, 1, 0, 0, 1, 1, -1, -1}; // 행 변화량
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1}; // 열 변화량

        // 시작점 또는 끝점이 막혀 있는 경우(1) 즉시 -1 반환
        if (grid[0][0] == 1 || grid[rl-1][cl-1] == 1) return -1;

        // bfs, 시작점 큐에 넣기
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[] {0, 0, 1}); // (0, 0), 거리 1
        visited[0][0] = true; // 시작점 방문 표시

        // bfs 탐색 시작
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            int r = cur[0], c = cur[1], dist = cur[2]; // 현재 위치(r, c), 현재까지의 거리

            // 도착점에 도달했는지 확인 => return
            if (r == rl-1 && c == cl-1) return dist;

            // 8방향으로 이동 시도
            for (int i=0; i<8; i++) {
                int nr = r + dr[i]; // 다음 행 위치
                int nc = c + dc[i]; // 다음 열 위치
                // 유효한 위치인지, 벽(1)이 아닌지, 방문하지 않은 위치인지 확인
                if (0 <= nr && nr < rl && 0 <= nc && nc < cl && grid[nr][nc] == 0 && !visited[nr][nc]) {
                    q.add(new int[] {nr, nc, dist + 1}); // 큐에 추가하고 경로 길이 +1
                    visited[nr][nc] = true; // 방문 표시
                }
            }

        }
        return -1;
    }
}
