import java.util.*;
class Solution {
    static final int MOD = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        dp[0][1] = 1;
        
        for(int[] arr : puddles) dp[arr[1]][arr[0]] = -1;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
                }
            }
        }
        
        return dp[n][m];
    }
}