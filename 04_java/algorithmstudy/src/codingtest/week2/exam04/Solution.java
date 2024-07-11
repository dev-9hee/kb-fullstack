package codingtest.week2.exam04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

// Lv.2 : 큐
// 문제4) 기능개발
// 코테스터디 풀이
public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>(); //-> cnt 갱신될때마다 추가해주려고!
        Deque<Integer> q = new ArrayDeque<>(); // 값을 순차적으로 처리하기 위해서 q를 사용!

        for(int i=0; i<progresses.length; i++){ //배열의 길이만큼 탐색
            int workDays = (100- progresses[i]) / speeds[i]; // workdays = 작업을 끝내는데 필요한 기간
            if((100- progresses[i]) % speeds[i] !=0) workDays++; // 나머지가 남아있을경우 workdays++;

            q.offer(workDays); // 순차적으로 처리하기위해 q 에다가 값을 추가해줍니다
        }

        int cnt = 1; // 기간마다 처리한 작업의 수
        int nowWorkDays = q.poll(); // q의 맨처음값을 꺼내줍니다
        while(!q.isEmpty()){
            if(q.peek() <= nowWorkDays){ //q의 다음값이 현재 작업값(nowWorkDays)보다 작거나 같은경우
                // -> nowWorkDays 가 끝나야만 작업을 할 수 있으므로 cnt ++
                q.poll(); //cnt ++ 해줬기때문에 값을 제거
                cnt++;
            } else { //nowWorkDays 를 갱신해야 하는 경우
                list.add(cnt); //지금까지 작업했던 cnt 를 ArrayList 에 추가해줍니다.
                nowWorkDays = q.poll(); // 다음값을 꺼내서 nowWorkDays 를 갱신해주고,
                cnt = 1; // 최소 작업단위수는 1이므로 cnt 를 1로 갱신해줍니다.
            }
        }

        list.add(cnt);
        // cnt == 1(값이 갱신된 경우) 이거나
        // cnt >=1(값이 갱신되지 않은경우)


        int[] answer = new int [list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
