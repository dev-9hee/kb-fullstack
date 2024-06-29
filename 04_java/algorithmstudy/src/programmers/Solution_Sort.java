package programmers;

import java.util.Arrays;

public class Solution_Sort {
    public String solution(String[] participant, String[] completion) {
        // 1. 두 배열을 정렬한다
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 2. 두 배열이 다를 때까지 찾는다
        int i = 0;
        for(i=0;i<completion.length;i++)
            if(!participant[i].equals(completion[i]))
                break;

        // 3. 여기까지 왔다는 것은 마지막 주자가 완주하지 못했다는 의미이다.
        return participant[i];
    }
    public static void main(String[] args){
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"eden", "kiki"};
        Solution_Sort sol = new Solution_Sort();
        System.out.println(sol.solution(part, comp));
    }
}
