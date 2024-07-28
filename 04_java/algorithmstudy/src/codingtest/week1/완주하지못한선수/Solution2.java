package codingtest.week1.완주하지못한선수;

import java.util.Arrays;

// Lv.1 : 해시
// 문제1) 완주하지 못한 선수
public class Solution2 {
    public String solution(String[] participant, String[] completion) {
        // 배열 정렬 해줌 - O(nlogn)
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;

        // i 0 ~ n-1 순회 - O(n)
        // i = 2이 되면 i < completion.length 조건이 거짓이 되어 루프가 종료
        for (i=0; i<completion.length; i++) { // 0~1
            if (!participant[i].equals(completion[i])) { // 내용 비교, 같지 않으면
                return participant[i]; // 미완주자
            }
        }
        // 루프가 종료된 시점에서 i는 completion.length 와 같은 값을 갖게 됩
        // 순회 했는데 없어,,!, 마지막에 미완주자
        return participant[i]; // participant[completion.length]와 동일
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String[] participant = new String[] {"leo", "kiki", "eden"};
        String[] completion = new String[] {"eden", "kiki"};
        String result = solution.solution(participant, completion);
        System.out.println(result);
    }
}
