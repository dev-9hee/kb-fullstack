package week1.소수만들기;

import java.util.*; // 임포트하고 시작

// Lv.1 : 완전탐색, 수학
// 문제2) 소수 만들기
// 완전탬색 - 강사님 슈도코드 참고
public class Solution1 {
    public int solution(int[] nums) {
        int counter = 0; // 경우의 수 카운트
        //✅ nums 에서 숫자 세개를 고른다.
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    //✅ 세 숫자의 합이 소수라면 카운터를 1 증가시킨다.
                    if (isPrime(nums[i] + nums[j] + nums[k])) counter++;
                }
            }
        }
        return counter;
    }

    // 소수 판별 함수
    private boolean isPrime(int n) { // n은 세 개의 숫자를 더한 숫자
        //✅ i * i == n 까지 숫자로 n을 나누어본다. 나누어 떨어진다면 소수로 판별한다.
        // 1은 소수가 아님, 2부터 탐색, 소수는 1과 자신 빼고 나누어 지는 수가 없어야 된다.
        // i*i<=n에 루트를 씌우면 i<=루트 n => 즉, 반 이상의 큰 수로 나누면 자신 외에 나머지가 0이 되는 수는 없다..!
        for (int i = 2; i*i<=n; i++) {
            if (n % i == 0) return false; // 1과 나 빼고 다른 수로 나눠지면 소수 아님
        }
        return true;
    }

    // 실행
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int res = solution.solution(new int[]{1,2,7,6,4});
        System.out.println(res);
    }
}
