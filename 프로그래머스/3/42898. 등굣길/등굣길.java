import java.util.*;
class Solution {
    static int[][] map;
    static boolean[][] isPuddles;
    static final int MOD = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        init(m, n, puddles);
        dp();
        return map[m][n];
    }
    
    public void dp() {
        for(int i=1; i<map.length; i++) {
            for(int j=1; j<map[0].length; j++) {
                if(i==1 && j==1) continue;
                if(!isPuddles[i][j]) {
                    // map[i][j] = (map[i-1][j] % MOD) + (map[i][j-1] % MOD);
                    map[i][j] = (map[i-1][j] + map[i][j-1]) % MOD;
                }
            }
        }
    }
    
    public void init(int m, int n, int[][] puddles) {
        map = new int[m+1][n+1];
        map[1][1] = 1;
        
        isPuddles = new boolean[m+1][n+1];
        
        for(int[] arr : puddles) {
            isPuddles[arr[0]][arr[1]] = true;
        }
    }
}