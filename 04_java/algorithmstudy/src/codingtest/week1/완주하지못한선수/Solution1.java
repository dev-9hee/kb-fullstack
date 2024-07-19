package week1.완주하지못한선수;

import java.util.*;

// Lv.1 : 해시
// 문제1) 완주하지 못한 선수
public class Solution1 {
    public String solution(String[] participant, String[] completion) {
        // 배열을 정렬해줌, 사전순으로 정렬 - O(nlogn)
        Arrays.sort(participant); // 마라톤에 참여한 선수들의 이름
        Arrays.sort(completion); // 완주한 선수들의 이름

        // completion 배열이 participant 길이보다 1 작음 => 즉, 완주하지 못한 선수는 1명
        // 배열의 길이가 더 작은 completion 배열의 길이로 for 문 돌리기
        for (int i=0; i<completion.length; i++) {
            // 정렬했으므로 같은 인덱스의 값이 같지 않다면 participant 인덱스에 있는 선수가 완주하지 못한거!!
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }

        // for 문을 돌 동안 만족하지 못했다면 참가자의 마지막 선수가 완주하지 못한거다!
        return participant[participant.length-1];
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};
        String result = solution.solution(participant, completion);
        System.out.println(result);
    }
}
