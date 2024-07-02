package codingtest.week1.exam02;

import java.util.*;

// Lv.1 : 완전탐색, 수학
// 문제2) 소수 만들기
// 내 풀이, 망함
public class Solution2 {
    public int solution(int[] nums) {

        Random random = new Random();

        int[] pickedNumbers = new int[3];
        boolean[] pickedFlags = new boolean[nums.length];
        int pickedCount = 0;

        while (pickedCount < 3) {
            int index = random.nextInt(nums.length);
            if (!pickedFlags[index]) {
                pickedNumbers[pickedCount++] = nums[index];
                pickedFlags[index] = true;
            }
        }
        int sum = 0;
        int count = 0;

        for (int i=0; i<pickedNumbers.length; i++) {
            sum += pickedNumbers[i];
        }
        if (sum%2 != 0) {
            count++;
        }
        return count;
    }
}
