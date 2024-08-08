package codingtest.week5.미로탈출;

import java.util.*;

public class Solution {
    public int solution(String[] maps) {
        // ✅ 주어진 입력을 사용하기 좋게 전처리한다.
        int n = maps.length; // 행 수
        int m = maps[0].length(); // 열 수
        char[][] maze = new char[n][m]; // 미로를 저장할 2차원 배열 생성
        // 시작 지점, 레버 지점, 출구 지점을 저장할 배열
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];

        // 주어진 문자열 배열을 탐색하면서 각 지점의 위치를 찾음
        for (int r = 0; r < n; r++) {
            maze[r] = maps[r].toCharArray(); // 문자열을 문자 배열로 변환
            for (int c=0; c < m; c++) {
                if (maze[r][c] == 'S') { // 시작 지점 'S'의 위치를 찾음
                    start[0] = r;
                    start[1] = c;
                } else if (maze[r][c] == 'L') { // 레버 지점 'L'의 위치를 찾음
                    lever[0] = r;
                    lever[1] = c;
                } else if (maze[r][c] == 'E') { // 출구 'E'의 위치를 찾음
                    exit[0] = r;
                    exit[1] = c;
                }
            }
        }

        // ✅ 시작 지점에서 레버까지의 최단 거리를 구함
        int toLever = bfs(maze, start, lever, n, m);
        // 레버까지 도달할 수 없다면 -1을 반환
        if (toLever == -1) return -1;

        // ✅ 레버에서 출구까지의 최단 거리를 구함
        int toExit = bfs(maze, lever, exit, n, m);
        // 출구까지 도달할 수 없다면 -1을 반환
        if (toExit == -1) return -1;

        // ✅ 두 구간의 최단 거리를 더한 값을 반환
        return toLever + toExit;
    }

    // // ✅ BFS 알고리즘을 사용하여 미로에서 최단 거리를 찾는 메소드
    public int bfs(char[][] maze, int[] start, int[] target, int n, int m) {
        boolean[][] visited = new boolean[n][m]; // 방문 여부를 체크하기 위한 2차원 배열
        // 상하좌우 네 방향을 나타내는 배열
        int[] dr = {-1, 1, 0, 0}; // 행 변화량
        int[] dc = {0, 0, -1, 1}; // 열 변화량

        // BFS 를 위한 큐 생성 (현재 위치와 이동 거리를 함께 저장)
        Queue<int[]> queue  = new ArrayDeque<>();
        queue.add(new int[]{start[0], start[1], 0}); // 시작 위치와 초기 거리 0을 큐에 추가
        visited[start[0]][start[1]] = true; // 시작 위치는 방문한 것으로 표시

        // ✅ BFS 탐색 시작
        while (!queue.isEmpty()) {
            // 큐에서 현재 위치와 거리를 꺼냄
            int[] cur = queue.remove();
            int r = cur[0], c = cur[1], dist = cur[2];

            // 네 방향으로 이동 시도
            for (int d=0; d<4; d++) {
                int nr = r + dr[d]; // 새로운 행 위치
                int nc = c + dc[d]; // 새로운 열 위치

                // ✅ 미로의 범위 내에서 이동 가능하며 벽이 아닌 경우
                if (0 <= nr && nr < n && 0 <= nc && nc < m && maze[nr][nc] != 'X') {
                    // 방문하지 않은 위치라면
                    if (!visited[nr][nc]) {
                        // 목표 지점에 도달하면 거리를 반환
                        if (nr == target[0] && nc == target[1]) return dist + 1;
                        // 그렇지 않다면 새로운 위치와 거리를 큐에 추가하고 방문 표시
                        queue.offer(new int[]{nr, nc, dist + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return -1; // 목표 지점에 도달할 수 없는 경우
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"});
        System.out.println(result);
    }
}
