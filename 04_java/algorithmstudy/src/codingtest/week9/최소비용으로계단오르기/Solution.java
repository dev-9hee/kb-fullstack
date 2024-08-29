package codingtest.week9.최소비용으로계단오르기;

public class Solution {
    public int solution(int[] cost) {
        int n = cost.length; // 계단의 총 개수
        int p1 = 0; // 현재 계단에 도달하기 위해 필요한 최소 비용을 저장
        int p2 = 0; // 이전 계단에 도달하기 위해 필요한 최소 비용을 저장
        // i는 2부터 시작하는데, 이는 p1과 p2가 첫 번째와 두 번째 계단 이전의 최소 비용을 나타내기 때문임!
        for (int i = 2; i <= n; i++) {
            // p1 + cost[i-1]: 바로 전 계단에서 현재 계단으로 이동할 때의 비용을 계산
            // p2 + cost[i-2]: 두 계단 전에 있던 위치에서 현재 계단으로 건너뛸 때의 비용을 계산
            // 이 두 값 중 작은 값을 선택하여 cur 에 저장, 이 값이 현재 계단에 도달하는 데 필요한 최소 비용
            int cur = Math.min(p1 + cost[i-1], p2 + cost[i-2]);
            p2 = p1; // 다음 계단으로 이동할 때, 현재 계단의 최소 비용(p1)을 이전 계단(p2)의 최소 비용으로 갱신
            p1 = cur; // 다음 계단으로 이동할 때, 현재 계산된 최소 비용(cur)을 현재 계단(p1)의 최소 비용으로 갱신
        }
        return p1; // 반복이 끝난 후, p1에는 마지막 계단에 도달하는 데 필요한 최소 비용이 저장
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.solution(new int[] {10, 15, 20});
        System.out.println(result);
    }
}
