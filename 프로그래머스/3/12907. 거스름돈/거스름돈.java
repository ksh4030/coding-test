import java.util.*;
class Solution {
    static final int MOD = 1_000_000_007;
    
    public int solution(int n, int[] money) {
        int answer = getCnt(n, money);
        return answer;
    }
    
    public int getCnt(int n, int[] money) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int one : money) {
            for(int i=one; i<=n; i++) {
                dp[i] += dp[i-one];
            }
        }
        return dp[n];
    }
}