package codingtest.week1.완주하지못한선수;

import java.util.*;

// Lv.1 : 해시
// 문제1) 완주하지 못한 선수
// 강사님 슈도코드 참고 : 해시테이블 이용
public class Solution3 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> counter = new HashMap<>(); // 해시맵 사용
        //✅ participant 를 순회하며 해시테이블에 이름, 인원수를 저장한다.
        for (String p : participant) {
            // getOrDefault(값, 기본값) : 지정된 키에 매핑된 값을 반환하거나, 키가 맵에 없으면 기본값을 반환
            // 인원수 + 1을 더해줘서 넣어줌
            counter.put(p, counter.getOrDefault(p, 0) + 1);
        }
        //✅ completion 을 순회하며 해시테이블의 인원수를 감소시킨다.
        for (String c : completion) {
            // put : 지정된 키와 값을 맵에 저장, 이미 키가 존재하는 경우, 그 키의 기존 값을 새로운 값으로 대체
            // replace : 지정된 키가 현재 맵에 존재할 때만 값을 대체... 즉, 키가 존재하지 않으면 아무런 동작도 하지 않는다.
            counter.replace(c, counter.get(c) - 1);
        }
        //✅ participant 를 순회하며 인원수가 1인 이름을 찾아 반환한다.
        for (String key : participant) {
            if (counter.get(key) == 1) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};
        String result = solution.solution(participant, completion);
        System.out.println(result);
    }
}

// 해시테이블에 participant 의 각 사람에 대해 이름을 key, 인원수를 value 로 저장한 뒤
// completion 을 순회하며 자신의 인원수를 하나씩 줄인다.
// 마지막에 인원수가 0이 되지 않은 이름이 완주하지 못한 사람이 될것이다.
