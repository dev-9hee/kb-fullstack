import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cake {
    public static void main(String[] args) throws IOException {
        /*
         * 케이크문제
         * 문제 : 어느날, 현수의 옆자리에 앉은 준일이형이 롤케이크를 가져왔다.
         * 롤케이크는 N등분 되어있는 케이크였으며, 준일이형 몰래 박스의 뒷면을보니
         * 케이크는 K번째 조각마다 잼이 많이 묻어있다고 한다.
         * 준일이형이 선뜻 케이크를 나눠먹자고 하자, 욕심이 생긴 현수는 양보하는 척
         * 형이 K-1 개를 먹을때마다, 본인이 한개씩 집어먹겠다고 얘기했다.
         * 케이크가 N등분 되어있고 K번째 마다 조각에 잼이 많이 뭍어 있고,
         * 케이크는 둘이서 전부 먹는다고 가정했을때,
         * 현수가 먹을 케이크의 조각은 몇번째 몇번째일지 출력하세요.
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //
        Queue<Integer> Cake = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            Cake.offer(i);
        }

        int count = 1;
        while(!Cake.isEmpty()) {
            int piece = Cake.poll();
            if (count == K) {
                System.out.println(piece + "번째 냠냠");
                count = 1;
            }
            else{
                count++;
                Cake.add(piece);
            }
        }
        System.out.println("배부르다!");
        br.close();

//        for (int i = K; i <= N; i+=K) {
//            Q.offer(i);
//        }
//        while (!Q.isEmpty()) {
//            int x = Q.poll();
//            System.out.println(x + "번째 맛있는 조간 냠냠");
//        }
        // 내가 풀다 만 코드
//        int sum = 0;
//
//        while (!Q.isEmpty()) { // 비어있지 않으면 반복
//            for (int j = K; j <= Q.size(); j++) {
//                if (Q.size()/K >= 0 ) {
//                    for (int k = 0; k < K; k++) {
//                        Q.poll();
//                    }
//                }
//                System.out.println(Q.poll() + "번째 맛있는 조각 냠냠");
//            }
//            break;
//        }
        //
    }
}
