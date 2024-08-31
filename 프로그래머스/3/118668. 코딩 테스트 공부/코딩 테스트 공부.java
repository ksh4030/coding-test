class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        // 1. 문제를 풀기 위한 최대 알고력과 최대 코딩력 구하기
        int maxAlp = 0;
        int maxCop = 0;
        
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        
        // 2. 초기 알고력과 코딩력이 이미 최대 요구치 이상이라면 제한
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        
        // 3. DP 테이블 초기화
        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int i = 0; i <= maxAlp; i++) {
            for (int j = 0; j <= maxCop; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[alp][cop] = 0;
        
        // 4. DP 탐색 시작
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                // 알고력 또는 코딩력을 1 올리는 경우
                if (i + 1 <= maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                if (j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                
                // 각 문제를 푸는 경우
                for (int[] problem : problems) {
                    int alpReq = problem[0];
                    int copReq = problem[1];
                    int alpRwd = problem[2];
                    int copRwd = problem[3];
                    int cost = problem[4];
                    
                    // 현재 상태에서 해당 문제를 풀 수 있는 경우
                    if (i >= alpReq && j >= copReq) {
                        int newAlp = Math.min(maxAlp, i + alpRwd);
                        int newCop = Math.min(maxCop, j + copRwd);
                        dp[newAlp][newCop] = Math.min(dp[newAlp][newCop], dp[i][j] + cost);
                    }
                }
            }
        }
        
        // 5. 결과 반환: 모든 문제를 풀 수 있는 최소 시간
        return dp[maxAlp][maxCop];
    }
}
