package codingtest.week7.보물지도;

import java.util.*;

// 보물지도
public class Solution {
    public int solution(int n, int m, int[][] hole) {
        //✅ 함정 위치를 표시한다.
        boolean[][] trap = new boolean[n+1][m+1];
        for (int[] h : hole) {
            trap[h[0]][h[1]] = true;
        }

        boolean[][][] visited = new boolean[n+1][m+1][2];
        Queue<int[]> queue = new ArrayDeque<>();
        visited[1][1][0] = true;
        queue.add(new int[]{ 1, 1, 0, 0 });

        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };

        //✅ BFS 탐색을 수행한다.
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int r = cur[0], c = cur[1], jumped = cur[2], dist = cur[3];

            //✅ 목적지에 도착했다면 최단거리를 반환한다.
            if (r == n && c == m) {
                return dist;
            }

            //✅ 한칸 이동하는 경우를 탐색한다.
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];

                if (nr >= 1 && nr <= n && nc >= 1 && nc <= m) {
                    if (!visited[nr][nc][jumped] && !trap[nr][nc]) {
                        visited[nr][nc][jumped] = true;
                        queue.add(new int[]{ nr, nc, jumped, dist + 1 });
                    }
                }
            }

            //✅ 점프를 뛰지 않은 경우에는 점프를 뛰는 경우도 탐색한다.
            if (jumped == 0) {
                for (int d = 0; d < 4; d++) {
                    int nr = r + 2 * dr[d], nc = c + 2 * dc[d];

                    if (nr >= 1 && nr <= n && nc >= 1 && nc <= m) {
                        if (!visited[nr][nc][1] && !trap[nr][nc]) {
                            visited[nr][nc][1] = true;
                            queue.add(new int[]{ nr, nc, 1, dist + 1 });
                        }
                    }
                }
            }
        }

        return -1;
    }
}
