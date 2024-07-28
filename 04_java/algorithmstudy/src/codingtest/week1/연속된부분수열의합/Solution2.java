package codingtest.week1.연속된부분수열의합;

// 문제4) Lv.2 - 연속된 부분 수열의 합
// 강사님 슈도코드 참고해서 풀이
public class Solution2 {
    public int[] solution(int[] sequence, int k) {
        //✅ 정답 범위의 초기값을 (0, 1,000,000)으로 설정한다.
        int[] answer = {0, 1000000}; // 합이 k가 되는 부분 배열의 시작과 끝 인덱스

        int total = 0; // 현재 부분 배열의 합
        int start = 0; // 현재 부분 배열의 시작 인덱스

        // ✅ end 를 0 ~ sequence.length - 1 까지 순회한다.
        // end 변수는 현재 부분 배열의 끝 인덱스를 나타냄, 배열의 처음부터 끝까지 순회
        for (int end = 0; end < sequence.length; end++) {
            // ✅ end 부분을 합계에 더한다.
            total += sequence[end]; // sequence[end] 값을 total 에 더하여 현재 부분 배열의 합을 갱신
            // ✅ 합계가 k보다 작거나 같을때까지 start 를 증가시킨다.
            while (total > k) { // 부분 배열의 합계가 k보다 클 때 반복
                // start 인덱스를 오른쪽으로 이동시키면서 sequence[start] 값을 total 에서 빼줌
                total -= sequence[start];
                start++;
            }
            // ✅ 합계가 k와 같고, 현재 윈도우가 우선순위가 더 높다면 정답을 현재 범위로 바꾼다.
            if (total == k && ((end - start) < (answer[1] - answer[0]))) {
                answer[0] = start;
                answer[1] = end;
            }
        }
        // ✅ 정답을 반환한다.
        return answer;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] result = sol.solution(new int[] {1, 1, 1, 2, 3, 4, 5}, 5);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}

/* 문제 분석
비내림차순(오름차순)으로 정렬된 수열에서 부분 수열의 합 k가 되는
부분수열의 시작인덱스와 종료인덱스 찾기
sequence[] : 주어진 수열
k : 부분수열의 합
합이 k인 부분 수열이 여러개라면 길이가 짧은 수열을 찾기
=> 길이가 짧은 수열이 여러개일 경우 시작인덱스가 작은 수열 찾기
*/
