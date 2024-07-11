package afternoon.collection.stack;

import java.util.Stack;

public class StackReverse {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String input = "다시합창합시다";

        char[] charArr = input.toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            stack.push(charArr[i]); // 스택에 넣기
        }

        char[] reverseArr = new char[charArr.length];
        int i = 0;
        // 스택이 완전히 빌 때까지 하나씩 값을 빼서 배열에 넣기
        while (!stack.isEmpty()) { // 비어있지않으면
            reverseArr[i++] = stack.pop();
        }

        // 배열을 문자열로 변환하여 반환
        String reversed = new String(reverseArr);

        System.out.println("input = " + input);
        System.out.println("reversed = " + reversed);
    }
}
