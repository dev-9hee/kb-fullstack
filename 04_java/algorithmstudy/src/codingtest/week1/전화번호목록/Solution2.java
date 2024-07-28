package codingtest.week1.전화번호목록;

import java.util.HashSet;
import java.util.Set;

// 문제5) Lv.2 - 해시 / 전화번호 목록
// 해시테이블 사용 - 강사님 슈도코드 참고
// 해시셋 => 중복허용 안 함, 요소의 순서를 보장하지 않음
public class Solution2 {
    public boolean solution(String[] phone_book) {
        // ✅ 해시셋에 phone_book 의 전화번호를 모두 저장한다.
        Set<String> hashSet = new HashSet<>();
        for (String number : phone_book) {
            hashSet.add(number);
        }

        // ✅ phone_book 의 모든 전화번호를 순회한다.
        for (String num : phone_book) {
            // ✅ i를 1 ~ n까지 순회하며 0 ~ i 까지 부분문자열을 구한다.
            for (int i = 1; i < num.length(); i++) {
                // ✅ 부분문자열이 해시셋에 있다면 false 를 반환한다.
                String sub = num.substring(0, i);
                if (hashSet.contains(sub)) return false;
            }
        }
        // ✅ 접두어를 찾지 못했다면 true 를 반환한다.
        return true;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        boolean result = sol.solution(new String[] {"119", "97674223", "1195524421"});
        System.out.println(result);
    }
}
