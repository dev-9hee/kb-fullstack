package codingtest.week3.소수찾기;

import java.util.*;

public class Solution {
    Set<Integer> candidates = new HashSet<>(); // 중복을 허용하지 않는 데이터 구조로, 생성된 모든 숫자 조합을 저장, 소수 후보들
    public int solution(String numbers) {
        // 재귀를 이용해 가능한 숫자 조합을 모두 생성
        permutation(numbers, 0, new boolean[numbers.length()], 0);

        // 각 숫자 조합을 확인하여 소수의 개수 구하기
        int ans = 0;
        for (int num : candidates) {
            if (isPrime(num)) ans++; // 소수라면 개수를 증가
        }
        return ans;
    }

    // 순열조합, 재귀 구현
    // numbers: 주어진 숫자 문자열 / cur: 현재까지 생성된 숫자 / visited: 방문 여부 / digit: 현재 자리수
    void permutation(String numbers, int cur, boolean[] visited, int digit) {
        if (digit == numbers.length()) return; // 모든 자리 수를 사용한 것이므로 더 이상 진행하지 않고 return

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) continue; // 이미 방문

            // newValue 는 현재까지의 숫자 조합(cur)에 이번에 선택한 숫자(numbers.charAt(i))를 추가
            // char 타입의 숫자 문자를 실제 숫자(int)로 변환하는 역할, 문자의 실제 숫자값 구하기
            // Math.pow(10, digit)는 10의 digit 제곱을 계산, 이는 현재 자리수를 결정
            int newValue = cur + (int)((numbers.charAt(i) - '0') * Math.pow(10, digit));
            candidates.add(newValue);

            visited[i] = true; // 방문표시
            permutation(numbers, newValue, visited, digit + 1); // 다음 자리수(digit + 1)로 재귀 호출
            visited[i] = false; // 백트래킹을 통해 이전에 사용했던 숫자 선택을 취소하고, 다른 경로를 시도할 수 있게 하기 위함
        }
    }

    // 소수 판별
    boolean isPrime(int n) {
        if ( n < 2 ) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution("17");
        System.out.println(result);
    }
}
