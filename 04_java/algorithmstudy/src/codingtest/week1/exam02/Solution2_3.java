package codingtest.week1.exam02;

// Lv.1 : 완전탐색, 수학
// 소수 만들기
// 강사님 풀이 : 에라토스 테네스의 체(소수를 판별하는 알고리즘, 소수들을 대량으로 빠르고 정확하게 구하는 방법)
// 풀이 안해주심, 추가적인 내용
import java.util.*;
public class Solution2_3 {
    public int solution(int[] nums) {
        int count = 0;
        int maxSum = 2997;  // 최대 합은 1000 + 999 + 998 = 2997
        //✅ 에라토스 테네스의 체를 생성한다.
        boolean[] isPrime = sieveOfEratosthenes(maxSum);

        //✅ nums 에서 숫자 세개를 고른다.
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    //✅ 세 숫자의 합이 소수라면 카운터를 1 증가시킨다.
                    if (isPrime[sum]) count++;
                }
            }
        }

        return count;
    }

    private boolean[] sieveOfEratosthenes(int max) {
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true); // 배열의 모든 요소를 특정 값으로 설정할 수 있는 클래스
        isPrime[0] = isPrime[1] = false;  // 0과 1은 소수가 아님

        // 제곱근보다 작은 수는 앞에서 다 처리
        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        Solution2_2 solution = new Solution2_2();
        int result = solution.solution(nums);
        System.out.println(result);
    }
}
