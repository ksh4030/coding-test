import java.util.*;
class Solution {
    static int[] dp;
    public int solution(int[][] info, int n, int m) {
        int answer = Integer.MAX_VALUE;
        dp = new int[121];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        dp(info, n, m);
        
        for(int i=0; i<m; i++) {
            answer = Math.min(answer, dp[i]);
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    public void dp(int[][] info, int n, int m) {
        for(int[] arr : info) {
            int aRoot = arr[0];
            int bRoot = arr[1];
            int[] next = new int[121];
            Arrays.fill(next, Integer.MAX_VALUE);
            
            for(int b=0; b<121; b++) {
                if(dp[b] == Integer.MAX_VALUE) continue;
                
                if(dp[b] + aRoot < n) {
                    next[b] = Math.min(next[b], dp[b] + aRoot);
                }
                
                if(b + bRoot < m) {
                    next[b + bRoot] = Math.min(next[b + bRoot], dp[b]);
                }
            }
            
            dp = next;
        }
    }
}