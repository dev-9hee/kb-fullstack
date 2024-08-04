package codingtest.week2.괄호회전하기;

import java.util.*;

// Lv.2 : 스택
// 문제2) 괄호 회전하기
// 강사님 풀이
public class Solution {
    public int solution(String s) {
        // 움직이지 말고 s 수 만큼 덩어리 잡아서 비교
        String extendedS = s + s;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            // substring(i, s.length() + i)는 extendedS의 부분 문자열을 추출
            // 이 부분 문자열은 i부터 s.length() + i 까지의 문자열을 의미
            if (isValid(extendedS.substring(i, s.length() + i))) ans++;
        }
        return ans;
    }

    private boolean isValid(String s) { // O(n)
        Deque<Character> stack = new ArrayDeque<>();

        // 문자열을 배열로 반환한 걸 current 변수에 넣기
        for (char current : s.toCharArray()) {
            if (current == '(' || current == '[' || current == '{') { // 여는 괄호일 때 스택에 push
                stack.push(current);
            } else {
                if (stack.isEmpty()) return false;

                char target = stack.pop();
                if ((target == '(' && current != ')') ||
                        (target == '{' && current != '}') ||
                        (target == '[' && current != ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("}]()[{");
        System.out.println(result);
    }

    // 6번 돈다.
    // 1번 : 동작 예시 "}]()[{"
    /*
    문자 } : 닫는 괄호, 스택 비어있음, return false;
    => false 리턴
    */

    // 2번 : 동작 예시 "]()[{}"
    /*
    문자 ] : 닫는 괄호, 스택 비어있음, return false;
    => false 리턴
    */

    // 3번 : 동작 예시 "()[{}]"
    /*
    문자 ( : 여는 괄호, 스택에 푸시 / 스택 상태 : (
    문자 ) : 닫는 괄호, 스택에서 팝 / current = '(' (매칭 성공) / 스택 상태 : 비어있음
    문자 [ : 여는 괄호, 스택에 푸시 / 스택 상태 : [
    문자 { : 여는 괄호, 스택에 푸시 / 스택 상태 : [, {
    문자 } : 닫는 괄호, 스택에서 팝 / current = '{' (매칭 성공) / 스택 상태 : [
    문자 ] : 닫는 괄호, 스택에서 팝 / current = '[' (매칭 성공) / 스택 상태 : 비어있음
    => true 리턴 => ans = 1
    */

    // 4번 : 동작 예시 ")[{}]("
    /*
    문자 ) : 닫는 괄호, 스택 비어있음, return false;
    => false 리턴
    */

    // 5번 : 동작 예시 "[{}]()"
    /*
    문자 [ : 여는 괄호, 스택에 푸시 / 스택 상태 : [
    문자 { : 여는 괄호, 스택에 푸시 / 스택 상태 : [, {
    문자 } : 닫는 괄호, 스택에서 팝 / current = '{' (매칭 성공) / 스택 상태 : [
    문자 ] : 닫는 괄호, 스택에서 팝 / current = '[' (매칭 성공) / 스택 상태 : 비어있음
    문자 ( : 여는 괄호, 스택에 푸시 / 스택 상태 : (
    문자 ) : 닫는 괄호, 스택에서 팝 / current = '(' (매칭 성공) / 스택 상태 : 비어있음
    => true 리턴 => ans = 2
    */

    // 6번 : 동작 예시 "{}]()["
    /*
    문자 { : 여는 괄호, 스택에 푸시 / 스택 상태 : {
    문자 } : 닫는 괄호, 스택에서 팝 / current = '{' (매칭 성공) / 스택 상태 : 비어있음
    문자 ] : 닫는 괄호, 스택 비어있음, return false;
    => false 리턴
    */

    // 문자열 다 돌았다!!!
}
