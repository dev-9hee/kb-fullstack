package codingtest.week9.석유;

import java.util.*;

public class Solution {
    private boolean[][] visited;
    private int[] dr = {1, 0, -1, 0};
    private int[] dc = {0, 1, 0, -1};
    private int n;
    private int m;

    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        Map<Integer, Integer> totalOils = new HashMap<>();

        int answer = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (land[r][c] == 1 && !visited[r][c]) {
                    Set<Integer> cols = new HashSet<>();
                    int oils = bfs(land, r, c, cols);

                    for (int col : cols) {
                        totalOils.put(col, totalOils.getOrDefault(col, 0) + oils);
                    }
                }
            }
        }

        for (int value : totalOils.values()) {
            answer = Math.max(answer, value);
        }

        return answer;
    }

    private int bfs(int[][] land, int startR, int startC, Set<Integer> cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        int oils = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            oils++;
            cols.add(c);

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && land[nr][nc] == 1 && !visited[nr][nc]) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return oils;
    }
}