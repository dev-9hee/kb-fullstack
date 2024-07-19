package week1.완주하지못한선수;

import java.util.*;

// Lv.1 : 해시
// 문제1) 완주하지 못한 선수
// 강사님 슈도코드 참고 : 해시테이블 이용, 얼리리턴을 이용한 최적화
public class Solution4 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> counter = new HashMap<>(); // 해시맵 사용

        //✅ completion 을 순회하며 해시테이블에 이름, 인원수를 저장한다.
        for (String c : completion) {
            // compute 메서드는 주어진 키에 대해 계산을 수행하고, 그 결과를 맵에 저장
            // 값이 null 이면 1, 값이 있으면 그 값에 1을 더해서 저장
            counter.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        //✅ participant 를 순회한다.
        for (String p : participant) {
            //✅ 해시테이블에 저장되지 않았거나 인원이 0이 되었다면 이름을 반환한다.
            if (!counter.containsKey(p) || counter.get(p) == 0) {
                return p;
            }
            //✅ 인원수를 감소시킨다.
            // 현재 값 v에서 1을 빼서 새로운 값을 설정... 즉, v - 1을 반환하여 p 키에 대한 값을 업데이트
            counter.compute(p, (k, v) -> v - 1);
        }
        return null;
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};
        String result = solution.solution(participant, completion);
        System.out.println(result);
    }
}

// 해시테이블에 completion 의 각 사람에 대해 이름을 key, 인원수를 value 로 저장한 뒤
// participant 를 순회하며 자신의 인원수를 하나씩 줄여간다.
// 인원수가 0이 되거나 저장되지 않은 키가 발견되면 완주하지 못한 것으로 판단

// compute 메서드는 주어진 키에 대해 계산을 수행하고, 그 결과를 맵에 저장
// p: 키입니다. 이 키의 값이 업데이트
// (k, v) -> (v == null) ? 1 : v + 1: 두 개의 인자를 받습니다
// k: 현재 맵에서의 키 (p와 동일)
// v: 현재 키에 매핑된 값 (p에 대한 값, 존재하지 않을 경우 null)