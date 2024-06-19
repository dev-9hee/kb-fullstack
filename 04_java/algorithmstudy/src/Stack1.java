import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준 17608번 막대기
public class Stack1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("수를 입력하세요 : ");
        int input = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int sum = 0;

        for (int i = 0; i < input; i++) {
            stack.push(Integer.valueOf(br.readLine())); // 스택에 주입
        }
        int height = 0; // 기준 높이
        int count = 0; // 보이는 탑의 개수

        while (!stack.isEmpty()) { // 스택이 비어 있으면 false, 무한 반복 나옴
            int v = stack.pop(); // 우리가 보는 값
            if(height<v) {
                height = v;
                count++;
            }
        }
        System.out.println("보이는 갯수 : " + count);
    }
}
