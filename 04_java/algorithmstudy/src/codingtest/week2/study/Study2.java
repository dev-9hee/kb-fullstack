package week2.study;

import java.util.*;

// 유효한 괄호
public class Study2 {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') { // 여는 괄호일 때 스택에 push
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop(); // 방금 꺼낸 스텍
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Study2 study2 = new Study2();
        boolean result = study2.isValid("()[{}]");
        System.out.println(result);
    }

    // 동작 예시 "()[{}]"
    /*
    문자 ( : 여는 괄호, 스택에 푸시 / 스택 상태 : (
    문자 ) : 닫는 괄호, 스택에서 팝 / top = '(' (매칭 성공) / 스택 상태 : 비어있음
    문자 [,{ : 여는 괄호, 스택에 푸시 / 스택 상태 : [, {
    문자 } : 닫는 괄호, 스택에서 팝 / top = '{' (매칭 성공) / 스택 상태 : [
    문자 ] : 닫는 괄호, 스택에서 팝 / top = '[' (매칭 성공) / 스택 상태 : 비어있음
    => true 리턴
    */
}
