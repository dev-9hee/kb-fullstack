package study;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0; // 리턴할 값 - dp[alp_target][cop_target], 목표 알고력과 코딩력을 얻는 최단시간
        int alp_target = 0;
        int cop_target = 0;

        // 문제를 돌면서 알고력과 코딩력의 목표치를 구함
        for (int i=0; i<problems.length; i++) {
            alp_target = Math.max(problems[i][0], alp_target); // 알고력 최종 목표값
            cop_target = Math.max(problems[i][1], cop_target); // 코딩력 최종 목표값
        }

        /* 목표치를 넘었을 때 [목표알고력][목표코딩력]로 반환 */
        // 이미 알고력과 코딩력이 목표치를 넘었으면 바로 0 반환
        if (alp >= alp_target && cop >= cop_target) {
            return 0;
        }

        // 초기 알고력이 이미 목표치보다 크면 목표치로 설정
        if (alp >= alp_target) {
            alp = alp_target;
        }

        // 초기 코딩력이 이미 목표치보다 크면 목표치로 설정
        if (cop >= cop_target) {
            cop = cop_target;
        }

        // dp[i][j]는 알고력 i와 코딩력 j를 달성하는 데 필요한 최소 시간을 의미
        int[][] dp = new int[alp_target+2][cop_target+2]; // 최종 목표값 +2 만큼 크기의 dp 배열 생성
        // dp 배열을 최대값으로 초기화
        for (int i=alp; i<=alp_target; i++) {
            for (int j=cop; j<=cop_target; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[alp][cop] = 0; // 시작점 (현재 알고력과 코딩력)에서의 시간은 0

        // dp 배열을 채워나감
        for (int i=alp; i<=alp_target; i++) {
            for (int j=cop; j<=cop_target; j++) {

                // 1. 공부를 통해 알고력과 코딩력을 1씩 증가시키는 경우
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1); // 알고력 트레이닝 - 알고력 +1당 시간 +1
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1); // 코딩력 트레이닝 - 코딩력 +1당 시간 +1

                // 2. 문제를 풀어서 알고력과 코딩력을 얻는 경우
                for (int m=0; m<problems.length; m++) {

                    // 현재 알고력과 코딩력이 문제를 해결할 수 있는 조건을 넘었을 경우
                    if (i >= problems[m][0] && j >= problems[m][1]) {

                        // 알고력과 코딩력이 모두 목표치를 넘었을 경우
                        if (i+problems[m][2] > alp_target && j+problems[m][3] > cop_target) {
                            dp[alp_target][cop_target] = Math.min(dp[alp_target][cop_target], dp[i][j] + problems[m][4]);
                        } // 알고력이 목표치를 넘겼을 경우
                        else if (i+problems[m][2] > alp_target) {
                            dp[alp_target][j+problems[m][3]] = Math.min(dp[alp_target][j+problems[m][3]], dp[i][j]+problems[m][4]);
                        } // 코딩력이 목표치를 넘겼을 경우
                        else if (j+problems[m][3] > cop_target) {
                            dp[i+problems[m][2]][cop_target] = Math.min(dp[i+problems[m][2]][cop_target],dp[i][j]+problems[m][4]);
                        } // 목표치에 도달하지 못 한 경우, 알고력과 코딩력 모두 목표치를 넘지 않는 경우
                        else if (i+problems[m][2] <= alp_target && j+problems[m][3] <= cop_target){
                            dp[i+problems[m][2]][j+problems[m][3]] = Math.min(dp[i+problems[m][2]][j+problems[m][3]],dp[i][j]+problems[m][4]);
                        }
                    }
                }
            }
        }

        // 목표 알고력과 코딩력에 도달하기 위한 최소 시간을 반환!!!!!
        answer = dp[alp_target][cop_target];
        return answer;
    }
}