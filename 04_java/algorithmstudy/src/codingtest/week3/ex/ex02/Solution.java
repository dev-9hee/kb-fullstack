package codingtest.week3.ex.ex02;

import java.util.Arrays;
import java.util.HashSet;

// Lv.2 : 완전탐색
// 문제2 : 소수 찾기
// 앞에 한 선택이 뒤에 영향을 주기 때문에 => 순열 이용해서 풀기
// 중복 저장이 안되야 하기 때문에 hashset 사용
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("011");
        System.out.println(result);
    }
    HashSet<Integer> list = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;
        boolean[] isPrime = makeList();
        permutation(0, numbers, new boolean[numbers.length()], 0);

        for(int i : list){
            if(isPrime[i]) answer++;
        }

        return answer;
    }


    public void permutation(int current, String numbers, boolean[] visited, int digit){
        if(digit == numbers.length()) return;

        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                int newNumber = current + (int)((numbers.charAt(i)-'0') * Math.pow(10, digit));
                list.add(newNumber);

                permutation(newNumber, numbers, visited, digit+1);

                visited[i] = false;
            }
        }
    }

    public boolean[] makeList(){
        int limit = 10_000_000;
        boolean[] list = new boolean [limit];
        Arrays.fill(list,true);
        list[0] = false; list [1] = false;
        for(int i=2; i*i< limit; i++){
            for(int j=i*i; j<limit; j+=i){
                list[j] = false;
            }
        }

        return list;
    }
}

/*
17

0)
current : 0
visited : FF
digit : 0

- 1
0 + (1 - 0) * (10,0) = 1  -> list : 1

1)
current : 1
visited : TF
digit : 1
1 + (7-0) * (10,1) = 1 + 70 = 71 -> list : 1, 71

2)
current : 0
visited : FF
digit : 0
0 + (7-0) * (10,0) = 0 + 7 = 7 -> list : 1, 71 ,7

3)
current : 7
visited : FT
digit : 1
7 + (1-0) * (10,1) = 7 + 10 = 17 -> list : 1, 71, 7, 17
 */
