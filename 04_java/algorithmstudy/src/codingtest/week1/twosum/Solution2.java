package codingtest.week1.twosum;

import java.util.*;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        //  Map 인터페이스와 HashMap 구현 클래스를 이용해 해시테이블을 사용
        // 모든 데이터에 key 값은 무조건 존재해야 하며, 중복되는 key 값이 있어서는 안됨
        // ✅ 숫자와 숫자의 인덱스를 키, 밸류로 하는 빈 해시테이블을 만든다.
        Map<Integer, Integer> hashmap = new HashMap<>();
        // ✅ 숫자들을 순회한다.
        for (int i = 0; i < nums.length; i++) {
            // ✅ 목표값을 만들기 위한 나머지 숫자를 구한다.
            int need = target - nums[i];
            // ✅ 나머지 숫자가 해시테이블에 존재하면 그 수의 인덱스와 현재 인덱스를 반환한다.
            if (hashmap.containsKey(need)) {
                return new int[] {hashmap.get(need), i};
            } else {
                // ✅ 아니라면 해시테이블에 숫자와 인덱스를 추가한다.
                hashmap.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] result = solution.twoSum(new int[]{3,2,3}, 6);
        System.out.println(Arrays.toString(result));
    }
}

// nums 가 [3, 2, 4]이고 target 이 6일 때:
// 첫 번째 숫자 3 (i = 0):
// need = 6 - 3 = 3
// hashmap 는 비어있으므로 3은 해시맵에 존재하지 않습니다.
// hashmap 에 3을 키로 하고 0을 값으로 추가합니다. (hashmap = {3: 0})
// 두 번째 숫자 2 (i = 1):
// need = 6 - 2 = 4
// hashmap 에 4가 존재하지 않으므로 2와 인덱스 1을 추가합니다. (hashmap = {3: 0, 2: 1})
// 세 번째 숫자 4 (i = 2):
// need = 6 - 4 = 2
// hashmap 에 2가 존재하므로, hashmap.get(2)는 1을 반환합니다.
// 따라서 return new int[] {1, 2}가 실행됩니다.
// 결과적으로 [1, 2]가 반환됩니다. 이는 nums[1] + nums[2]가 6이기 때문
