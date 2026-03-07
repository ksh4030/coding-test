import java.util.*;
class Solution {
    static final int MOD = 1_000_000_007;
    static int[][] map;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        init(m,n,puddles);
        
        map[1][1] = 1;
        
        for(int i=1; i<map.length; i++) {
            for(int j=1; j<map[0].length; j++) {
                if(map[i][j] == -1) {
                    continue;
                } 
                if(map[i-1][j] > 0) {
                    map[i][j] += map[i-1][j] % MOD;
                } 
                if(map[i][j-1] > 0) {
                    map[i][j] += map[i][j-1] % MOD;
                }
            }
        }
        
        return map[n][m]%MOD;
    }
    
    public void init(int m, int n, int[][] puddles) {
        map = new int[n+1][m+1];
        
        for(int[] arr : puddles) {
            map[arr[1]][arr[0]] = -1;
        }
    }
}