package study.김서방찾기문제;

public class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        for(int i=0; i<= seoul.length; i++){ // seoul 배열의 길이 만큼 반복
            if(seoul[i].equals("Kim")){ // 배열에 Kim이 있다면
                answer = "김서방은 "+ i +"에 있다"; // 배열의 어느 위치에 있는지 알려주고
                break; // 이미 김서방을 찾았으니 굳이 계속 반복할 필요없으니 브레이크해서 나오기
            }
        }
        return answer;
    }
}