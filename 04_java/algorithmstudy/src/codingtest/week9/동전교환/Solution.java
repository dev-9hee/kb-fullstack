package codingtest.week9.동전교환;

import java.util.*;

// Bottom up 방식 사용
public class Solution {
    // 동전 개수를 의미하는 큰 값으로 초기화할 LIMIT 을 정의, 주어진 문제의 최대 금액(10000)보다 큰 값으로 초기화하기 위함
    final int LIMIT = 10001;

    // 동전 배열(coins)과 목표 금액(amount)을 입력받아, 최소 동전 개수를 반환하는 메서드
    public int solution(int[] coins, int amount) {
        // dp 배열을 생성하여 금액(amount)까지의 최소 동전 개수를 기록
        // dp[i]는 i 금액을 만들기 위한 최소 동전 개수를 의미
        int[] dp = new int[amount + 1]; // amount+1 크기의 최소 동전 개수를 기록하는 dp 배열 만들고

        // dp 배열을 LIMIT 값으로 초기화하여, 아직 계산되지 않은 부분을 표시
        // 10001로 초기화하는 이유는 금액을 만들 수 없는 경우와 구분하기 위해서
        Arrays.fill(dp, LIMIT); // 10001 로 초기화

        // 0원을 만들기 위해서는 동전이 하나도 필요하지 않으므로 dp[0]을 0으로 설정
        dp[0] = 0;

        // 1부터 amount 까지의 모든 금액에 대해 최소 동전 개수를 계산
        for (int i = 0; i <= amount; i++) {
            // 현재 금액 i를 만들 수 없는 경우, 다음 반복으로 패스!
            // dp[i]가 LIMIT 값이면 아직 계산되지 않은 금액이므로 건너 뜀
            if (dp[i] == LIMIT) continue;
            // coins 의 각 동전을 탐색
            for (int coin : coins) {
                // 현재 금액 i에 동전 coin 을 더한 금액(i + coin)이 목표 금액을 넘거나, 0보다 작은 경우는 건너뜀!
                if (i + coin > amount || i + coin < 0) continue;
                // 현재 금액(i)에 동전 coin 을 추가한 금액(i + coin)을 만들기 위해 필요한 최소 동전 개수를 계산
                // 현재 dp[i + coin] 값보다 dp[i] + 1이 작은 경우(즉, 더 적은 동전 개수로 만들 수 있는 경우) dp[i + coin]을 갱신
                dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
            }
        }
        // 목표 금액에 대해 조합 가능 최소 동전 개수가 10001이면, -1을 반환
        // 아니라면, 계산한 목표 금액에 대해 조합 가능 최소 동전 개수를 반환
        return (dp[amount] == LIMIT) ? -1 : dp[amount];
    }
}

// dp 배열은 각 금액에 대해 만들 수 있는 최소 동전 개수를 기록
// 초기값을 LIMIT 로 설정하는 이유는 해당 금액을 만들 수 없는 상태를 나타내기 위해서