package codingtest.week1.exam04;

// 문제4) Lv.2 - 연속된 부분 수열의 합
// 강사님 풀이
public class Solution4_2 {
    public int[] solution(int[] sequence, int k) {
        // 부분수열의 합은 k, 합이 k인 부분수열이 여러개인 경우 길이가 짧은 수열을 찾음
        // ✅ 정답 범위의 초기값을 (0, 1,000,000)으로 설정한다.
        int[] answer = {0, 1_000_000}; // 배열의 초기값설정

        int total = 0;
        int start = 0;

        // ✅ end 를 0 ~ sequence.length - 1 까지 순회한다.
        for (int end = 0; end < sequence.length; end++) {
            // ✅ end 부분을 합계에 더한다.
            total += sequence[end];

            // ✅ 합계가 k보다 작거나 같을때까지 start 를 증가시킨다.
            while (total > k) {
                total -= sequence[start];
                start++;
            }

            // ✅ 합계가 k와 같고, 현재 윈도우가 우선순위가 더 높다면 정답을 현재 범위로 바꾼다. - 갱신
            if (total == k) {
                if ((end - start) < (answer[1] - answer[0])) {
                    answer[0] = start;
                    answer[1] = end;
                }
            }
        }
        // ✅ 정답을 반환한다.
        return answer;
    }

    public static void main(String[] args) {
        Solution4_2 solution4 = new Solution4_2();
        int[] result2 = solution4.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");
    }
}
