package week1.twosum;

import java.util.*; // 임포트하고 시작하기

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        // 내 실수 : 인덱스 값을 반환하기 때문에 배열을 정렬하면 안 됨
        // for 문으로 탐색
        // ex> [1, 2, 3] , 탐색할 때 (1, 2) / (1, 3) / (2, 3) 이렇게 보면 됨
        // 유효한 답은 오직 하나뿐이므로 합이 target 일 걸 찾으면 return
        //✅ 2중 for 문으로 두 수를 선택한다.
        for (int i = 0; i < nums.length - 1; i++) { // 실수 : for 문 2개 사용해야 함
            for (int j = i+1; j < nums.length; j++) {
                //✅ 두 수의 합이 target 과 같으면 두 수의 인덱스를 반환한다.
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // 실행
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] result = solution.twoSum(new int[]{3,2,3}, 6);
        // 배열의 각 요소를 쉼표로 구분하고 대괄호로 감싸서 문자열 형태로 출력
        System.out.println(Arrays.toString(result));
//        System.out.println(result); // 이 경우 참조하는 주소가 출력이 됨
    }
}
