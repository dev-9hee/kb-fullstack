package codingtest.week1.exam01;

import java.util.*;

// Lv.1 : 해시
// 문제1) 완주하지 못한 선수
// 내 풀이
public class Solution1 {
    public String solution(String[] participant, String[] completion) {
        // 배열 정렬 해줌 - O(nlogn)
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;

        // i 0 ~ n-1 순회 - O(n)
        for (i=0; i<completion.length; i++) {
            if (!participant[i].equals(completion[i])) { // 내용 비교, 같지 않으면
                return participant[i]; // 미완주자
            }
        }
        // 순회 했는데 없어,,!, 마지막에 미완주자
        return participant[i];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};
        String result = solution.solution(participant, completion);
        System.out.println(result);
    }
}
