package week2.study;

import java.util.*;

// 프로그래머스 : 올바른 괄호 - 스택의 흐름이랑 비슷
// L2 : 스택/큐
// https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class Study1 {
    boolean solution(String s) {
        boolean answer = true; // 올바른 상태 점검
        Deque<Character> stack = new ArrayDeque<>();

        // 초반에 안되는거 거르기..! 꼭 필요하지는 않음
        if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') return false;

        // for 반복문을 돌려서 문자 하나하나에 접근
        for (int i = 0; i < s.length(); i++) {
            //  문자열의 특정 위치에 있는 문자를 반환하는 메서드, 문자열을 인덱스로 접근할 수 있게 해줌
            // s.toCharArray : 이걸써서 배열로 사용해도 됨
            char c = s.charAt(i);
            if (c == '(') { // 열린 괄호면
                stack.push(c);
            } else { // 닫힌 괄호면
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        answer = stack.isEmpty();
        return answer;
    }

    public static void main(String[] args) {
        Study1 study1 = new Study1();
        boolean result = study1.solution("(())()");
        System.out.println(result);
    }
}
