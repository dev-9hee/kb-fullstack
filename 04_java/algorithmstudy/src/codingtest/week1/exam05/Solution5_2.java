package codingtest.week1.exam05;

import java.util.HashSet;
import java.util.Set;

// 문제5) Lv.2 - 해시 / 전화번호 목록
// 강사님 풀이, 해시테이블 사용
public class Solution5_2 {
    public boolean solution(String[] phone_book) {
        // ✅ 해시셋에 phone_book 의 전화번호를 모두 저장한다.
        Set<String> prefixSet = new HashSet<>();
        for (String number : phone_book) {
            prefixSet.add(number);
        }


        // ✅ phone_book 의 모든 전화번호를 순회한다.
        for (String number : phone_book) {
            // ✅ i를 1 ~ n까지 순회하며 0 ~ i 까지 부분문자열을 구한다.
            for (int i = 1; i < number.length(); i++) {
                // ✅ 부분문자열이 해시셋에 있다면 false 를 반환한다.
                String sub = number.substring(0, i);
                if (prefixSet.contains(sub)) return false;
            }
        }

        // ✅ 접두어를 찾지 못했다면 true 를 반환한다.
        return true;
    }
}
