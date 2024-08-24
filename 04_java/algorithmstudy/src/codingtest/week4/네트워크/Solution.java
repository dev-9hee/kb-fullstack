package codingtest.week4.네트워크;

import java.util.*;

// 컴퓨터들 간의 네트워크 연결 상태를 바탕으로 전체 네트워크의 개수를 구하는 프로그램
public class Solution {
    public int solution(int n, int[][] computers) { // 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers
        int count = 0; // 네트워크의 개수
        boolean[] visited = new boolean[n]; // 방문 표시

        // 모든 컴퓨터를 기점으로 DFS 를 수행
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue; // 이미 방문된 컴퓨터 건너뜀
            dfs(n, computers, visited, i); // 방문되지 않은 컴퓨터에 대해서는 DFS 를 수행

            count++; // 네트워크의 개수를 증가, DFS 가 끝날 때마다 새로운 네트워크를 찾았다고 간주하고 count 를 증가
        }

        // 네트워크의 개수 반환
        return count; // 모든 컴퓨터에 대해 탐색이 완료된 후, count 변수에는 네트워크의 개수가 저장
    }

    // dfs 구현
    void dfs(int n, int[][] computers, boolean[] visited, int cur) { // cur : 현재 방문중인 컴퓨터
        visited[cur] = true; // 현재 컴퓨터 방문 표시

        for (int i = 0; i < n; i++) { // 현재 컴퓨터 cur 에서 i번 컴퓨터로의 모든 연결을 검사
            if (!visited[i] && computers[cur][i] == 1) { // 아직 방문되지 않았고, cur 컴퓨터와 연결되어 있다면
                dfs(n, computers, visited, i); // 해당 컴퓨터에 대해 다시 DFS 를 수행
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println("result = " + result);
    }
}
