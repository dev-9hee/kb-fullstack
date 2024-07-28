package codingtest.week1.연속된부분수열의합;

// 문제4) Lv.2 - 연속된 부분 수열의 합
// 내 풀이, 시간 초과
public class Solution1 {
    public int[] solution(int[] sequence, int k) {
        // 비내림차순 : 오름차순인데 같은 숫자가 있음
        int[] result = {-1, -1}; // 초기값으로 합이 k가 되는 부분 배열을 찾지 못한 경우를 나타냄

        // 첫 번째 루프 : 배열의 각 시작 인덱스를 순회
        for (int i = 0; i < sequence.length; i++) {
            int sum = 0; // 현재 부분 배열의 합을 저장
            // 두 번재 루프 : 배열의 나머지 부분을 순회
            for (int j = i; j < sequence.length; j++) {
                sum += sequence[j];
                if (sum == k) { // sum 이 k 와 같아지는 경우
                    // result[0]이 초기값 -1이거나,
                    // 현재 부분 수열의 길이가 기존의 가장 짧은 부분 배열보다 짧으면 result 값 갱신
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
        Solution1 solution4 = new Solution1();
        int[] result2 = solution4.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");
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
