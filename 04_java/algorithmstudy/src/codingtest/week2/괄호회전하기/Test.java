package codingtest.week2.괄호회전하기;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test {

    public int solution(String s) {
        String extendedS = s + s;
        int ans = 0; // x의 개수, 리턴할 값

        for (int i = 0; i < s.length(); i++) { // s의 길이만큼 회전
            if (isValid(extendedS.substring(i, s.length() + i))) ans++; // 참이면 수 x 의 개수 증가
        }
        return ans;
    }

    public boolean isValid(String s) { // 유효한가 판별하는 함수
        Deque<Character> stack = new ArrayDeque<>(); // 스택 선언, 문자 하나하나를 비교

        // 문자열을 배열로 반환한 걸 current 변수에 넣기
        for (char current : s.toCharArray()) {
            if (current == '(' || current == '{' || current == '[') { // 여는 괄호라면 스택에 추가
                stack.push(current);
            } else { // 닫는 괄호라면
                if (stack.isEmpty()) return false; // 스택이 비어있으면 여는 괄호가 없으므로 false 리턴

                char target = stack.pop(); // 맨 위에 있는 여는 괄호가 타겟
                if ((target == '(' && current != ')') ||
                        (target == '{' && current != '}') ||
                        (target == '[' && current != ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); // true 면 비어있다는 뜻이므로 유효한 괄호
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("}]()[{");
        System.out.println(result);
    }
}
