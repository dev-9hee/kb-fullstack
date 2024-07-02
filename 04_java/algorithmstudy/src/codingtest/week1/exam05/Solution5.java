package codingtest.week1.exam05;

import java.util.*;

// 문제5) Lv.2 - 해시 / 전화번호 목록
// 내 풀이
public class Solution5 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 정렬

        for (int i = 1; i < phone_book.length; i++) {
            boolean isContain = phone_book[i].contains(phone_book[i - 1]);
            if (isContain) { // 접두어이면
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        boolean result = solution5.solution(new String[]{"123","456","789"});
        System.out.println(result);
    }
}
