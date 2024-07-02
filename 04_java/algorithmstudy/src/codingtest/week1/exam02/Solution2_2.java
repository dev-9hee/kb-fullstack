package codingtest.week1.exam02;

// Lv.1 : 완전탐색, 수학
// 소수 만들기
// 강사님 풀이 : 완전 탐색 사용
// 이 방법으로 풀이 설명 하심, 시간 복잡도 : n^3
public class Solution2_2 {
    public int solution(int[] nums) {
        int counter = 0;
        // ✅ nums 에서 숫자 세개를 고른다.
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    //✅ 세 숫자의 합이 소수라면 카운터를 1 증가시킨다.
                    if (isPrime(nums[i] + nums[j] + nums[k])) counter++;
                }
            }
        }

        return counter;
    }

    // ✅ 2 ~ i * i == n 까지 숫자로 n을 나누어본다. 나누어 떨어진다면 소수로 판별한다.
    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) { // 시간 복잡도 : 루트 num
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        Solution2_2 solution = new Solution2_2();
        int result = solution.solution(nums);
        System.out.println(result);
    }
}
