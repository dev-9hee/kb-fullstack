import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 14

        Stack<Integer> stack = new Stack<>(); // 스택 선언

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // push 1
            String s = st.nextToken(); // push
            if (s.equals("push")) {
                int b = Integer.parseInt(st.nextToken());
                stack.push(b);
            }
            else if (s.equals("pop")) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    int p = stack.pop();
                    System.out.println(p);
                }
            } else if (s.equals("size")) {
                System.out.println(stack.size());
            } else if (s.equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (s.equals("top")) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
