package codingtest.week1.exam01;

import java.util.*;

// 완주하지 못한 선수, 강사님 풀이
// 구현1 : 정렬
public class Solution1_2 {
    public String solution(String[] participant, String[] completion) {
        // ✅ participant 와 completion 을 비내림차순으로 정렬한다.
        Arrays.sort(participant);
        Arrays.sort(completion);

        // ✅ i를 0 ~ completion.length 까지 순회한다.
        for (int i = 0; i < completion.length; i++) {
            //✅ participant 와 completion 이 다르면 반환한다.
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        // ✅ 마지막 인덱스까지 확인해도 정답이 나오지 않았다면 마지막 participant 를 반환한다.
        return participant[participant.length - 1];
    }

    public static void main(String[] args) {
        Solution1_2 solution = new Solution1_2();
        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};
        String result = solution.solution(participant, completion);
        System.out.println(result);
    }
}
