package codingtest.week1.소수만들기;

import java.util.*;

// Lv.1 : 완전탐색, 수학
// 문제2) 소수 만들기
// 에라토스 테네스의 체 (소수 판별을 위한 알고리즘) - 강사님 슈도코드 참고
// 2부터 시작하여 특정 숫자의 배수를 지워나가는 방식으로 소수를 구함
public class Solution2 {
    public int solution(int[] nums) {
        int count = 0; // 경우의 수
        int maxSum = 2997; // nums 의 각 원소는 1 이상 1,000 이하의 자연수, 1000 + 999 + 998 = 2997 이 최대값
        //✅ 에라토스 테네스의 체를 생성한다.
        boolean[] isPrime = sieveOfEratosthenes(maxSum);
        //✅ nums 에서 숫자 세개를 고른다.
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    //✅ 세 숫자의 합이 소수라면 카운터를 1 증가시킨다.
                    if (isPrime[nums[i] + nums[j] + nums[k]]) count++; // 세숫자의 합이 true 라면 경우의 수 + 1
                }
            }
        }
        return count;
    }

    // 에라토스 테네스의 체
    private boolean[] sieveOfEratosthenes(int max) {
        // max 크기의 boolean 형 배열 선언
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true); // isPrime 배열을 모두 true 로 설정
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아니기 때문에 false 로 미리 설정

        for (int i = 2; i*i < max; i++) {
            if (isPrime[i]) { // isPrime[i] 가 true 면.. 즉 소수라면
                for (int j = i * i; j < max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    // 실행
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int res = solution.solution(new int[]{1,2,7,6,4});
        System.out.println(res);
    }
}

// 에라토스테네스의 체 알고리즘 설명
// 2부터 시작하여 특정 숫자의 배수를 지워나가는 방식으로 소수를 구함
// 초기화: 2부터 n 까지의 숫자가 들어있는 리스트를 생성합니다.
// 첫 번째 소수 선택: 리스트에서 남아있는 숫자 중 가장 작은 수를 소수로 선택합니다.
// 배수 제거: 선택된 소수의 배수를 리스트에서 모두 제거합니다.
// 반복: 리스트에 남아있는 숫자 중 다음 소수를 선택하고, 그 배수를 제거하는 과정을 반복합니다.
// 종료: 리스트의 모든 숫자가 소수로 판별될 때까지 반복합니다.
