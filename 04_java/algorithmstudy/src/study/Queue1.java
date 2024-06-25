package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Queue1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());

        // 0. Queue 를 선언
        Queue<Integer> Q = new LinkedList<>(); // 연결리스트 사용

        //1. 1부터 N 까지를 Q에 더해봅시다 - add, offer(더 좋음, 예외처리를 해 줌)
        for(int i=1; i<=N; i++){
            Q.offer(i);
//            System.out.println(Q.size()); // 들어갔는지 확인
        }
        System.out.println();

        //2. 값을 조회하여봅시다 - element, peek, contains, size
        System.out.println("[ 값 조회 ]");
        System.out.println("Q.element() : " + Q.element()); // 맨 앞의 값 확인, 예외처리 안 하고 그대로 down
        System.out.println("Q.peek() : " + Q.peek()); // 맨 앞의 값 확인, 예외처리를 해 줌(어떤 값이든 반환해서 오류가 발생하지 않게), 더 좋음
        System.out.println("Q.contains(3) : " + Q.contains(3)); // 값(3)을 포함하고 있는지, true or false
        System.out.println("Q.size() : " + Q.size()); // 크기
        System.out.println();

        //3. 값을 삭제하여봅시다 - remove, poll, clear
        System.out.println("[ 값 삭제 ]");
        System.out.println("Q.remove() : " + Q.remove()); // 맨 앞의 값(1)을 삭제, 제거하고 제거한 값 가져오기, 에러처리 안 함
        System.out.println("Q.peek() : " + Q.peek()); // 맨 앞의 값을 확인, 많이 사용
        System.out.println("Q.poll() : " + Q.poll()); // 맨 앞의 값을 제거하고 제거한 값 가져오기, 많이 사용, 에러처리 함
        System.out.println("Q.poll() : " + Q.poll()); // 위와 동일
        System.out.println("Q.peek() : " + Q.peek()); // 맨 앞의 값
        Q.clear(); // 내용을 아예 초기화
        System.out.println("Q.peek() : " + Q.peek()); // 예외처리를 해줌, 비어있어도 null 반환
//        System.out.println(Q.element()); // 비어있으면 오류 발생
        System.out.println();

        //4. 값이 비어있는지 확인하여봅시다
        System.out.println("[ 값이 비어있는지 확인 ]");
        System.out.println("Q.isEmpty() : " + Q.isEmpty());
//        Q.add(1);
        Q.offer(1);
        System.out.println("Q.isEmpty() : " + Q.isEmpty());

        br.close(); // 버퍼를 다 사용하면 닫아줘야 함
    }
}
