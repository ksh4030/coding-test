class Solution {
    static final int MOD = 10007;
    public int solution(int n, int[] tops) {
        int answer = 0;
        int[][] dp = new int[n][2];
        
        dp[0][0] = tops[0] == 1 ? 3 : 2;
        dp[0][1] = 1;
        
        for(int i=1; i<n; i++) {
            int a = tops[i] == 1 ? 3 : 2;
            int b = tops[i] == 1 ? 2 : 1;
            dp[i][0] = (dp[i-1][0]*a + dp[i-1][1]*b) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }
        
        return (dp[n-1][0] + dp[n-1][1]) % MOD;
    }
}