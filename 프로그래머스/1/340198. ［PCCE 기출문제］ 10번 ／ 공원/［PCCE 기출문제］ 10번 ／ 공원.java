import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int maxSize = 0;
        int[][] dp = new int[park.length][park[0].length];
        
        for(int i=0; i<park.length; i++) {
            for(int j=0; j<park[0].length; j++) {
                if(park[i][j].equals("-1")) {
                    if(i==0 || j==0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                    }
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }
        
        Arrays.sort(mats);
        for(int i=mats.length-1; i>=0; i--) {
            if(mats[i] <= maxSize) return mats[i];
        }
        
        return answer;
    }
}