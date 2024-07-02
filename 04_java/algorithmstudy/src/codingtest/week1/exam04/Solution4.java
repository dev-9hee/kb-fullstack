package codingtest.week1.exam04;

// 문제4) Lv.2 - 연속된 부분 수열의 합
// 내 풀이, 시간 초과
public class Solution4 {
    public int[] solution(int[] sequence, int k) {
        // 비내림차순 : 오름차순인데 같은 숫자가 있음
        int[] result = {-1, -1}; // 초기값으로 합이 k가 되는 부분 배열을 찾지 못한 경우를 나타냄

        for (int i = 0; i < sequence.length; i++) {
            int sum = 0;
            for (int j = i; j < sequence.length; j++) {
                sum += sequence[j];
                if (sum == k) {
                    if (result[0] == -1 || (j - i) < (result[1] - result[0])) {
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] result2 = solution4.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");
    }
}
