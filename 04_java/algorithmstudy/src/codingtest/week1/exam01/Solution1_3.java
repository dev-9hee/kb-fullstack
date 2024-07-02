package codingtest.week1.exam01;

import java.util.*;

// 완주하지 못한 선수, 강사님 풀이
// 구현2 : 해시테이블
public class Solution1_3 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> counter = new HashMap<>();

        // ✅ participant 를 순회하며 해시테이블에 이름, 인원수를 저장한다.
        for(String p : participant) {
            counter.put(p, counter.getOrDefault(p, 0) + 1);
        }

        // ✅ completion 을 순회하며 해시테이블의 인원수를 감소시킨다.
        for (String c : completion) {
            counter.put(c, counter.get(c) - 1);
        }

        // ✅ participant 를 순회하며 인원수가 0인 이름을 찾아 반환한다.
        for (String key : counter.keySet()) {
            if (counter.get(key) != 0) {
                return key;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution1_3 solution = new Solution1_3();
        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};
        String result = solution.solution(participant, completion);
        System.out.println(result);
    }
}
