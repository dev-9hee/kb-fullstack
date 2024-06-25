package study;

import java.util.Stack;


public class Dfs {

    static int N, M, count;
    static int[][] graph; // 관계를 표시할 저장소
    static boolean[] visited; // 방문할 노드를 표시할 Boolean 배열

    public static void main(String[] args) {
        // 입력값 선언
        N = 7;
        M = 6;
        int[][] input = {
                {1, 2},
                {2, 3},
                {1, 5},
                {5, 2},
                {5, 6},
                {4, 7}
        };

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int a = input[i][0];
            int b = input[i][1];
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // 입력구간종료


        // dfs 파트
        dfs(1);

        // stack 사용
//        Stack<Integer> stack = new Stack<>();
//        stack.push(1); // 시작할 값
//        while(!stack.isEmpty()){
//            int top = stack.pop();
//            if(!visited[top]){ // 방문하지 않은 곳이라면
//                visited[top] = true;
//                System.out.println(top);
//                for(int i=N; i>=1; i--){ // 앞에 값부터 꺼내서 출력할 수 있게 하려고 이렇게 함
//                    if(graph[top][i] == 1 && !visited[i]) {
//                        stack.push(i);
//                    }
//                }
//            }
//        }
    }

    // 재귀함수 사용
    public static void dfs(int start){
        if(!visited[start])
            visited[start] = true;
        System.out.println(start);
        for(int i=1; i<=N; i++){
            if(graph[start][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }



}