package codingtest.week1.exam01;

import java.util.*;

// 완주하지 못한 선수, 강사님 풀이
// 구현3 : 해시테이블 (얼리리턴을 이용한 최적화)
public class Solution1_4 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> counter = new HashMap<>();

        // ✅ completion 을 순회하며 해시테이블에 이름, 인원수를 저장한다.
        for (String p : completion) {
            counter.compute(p, (k, v) -> (v == null) ? 1 : v + 1);
        }

        // ✅ participant 를 순회한다.
        for (String p : participant) {
            // ✅ 해시테이블에 저장되지 않았거나 인원이 0이 되었다면 이름을 반환한다.
            if (!counter.containsKey(p) || counter.get(p) == 0)
                return p;

            // ✅ 인원수를 감소시킨다.
            counter.compute(p, (k, v) -> v - 1);
        }

        return null;
    }

    public static void main(String[] args) {
        Solution1_4 solution = new Solution1_4();
        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};
        String result = solution.solution(participant, completion);
        System.out.println(result);
    }
}
