import java.util.*;
class Solution {
    final int MOD = 1_000_000_007;
    int[][] map;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[n+1][m+1];
        map[1][1] = 1;
        
        for(int i=0; i<puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        for(int i=1; i<map.length; i++) {
            for(int j=1; j<map[i].length; j++) {
                if(i==1 && j==1) continue;
                if(map[i][j] == -1) continue;
                
                map[i][j] = ((map[i-1][j] == -1 ? 0 : map[i-1][j]) + (map[i][j-1] == -1 ? 0 : map[i][j-1])) % MOD;
            }
        }
        answer = map[n][m];
        // for(int[] bucket : map) {
        //     System.out.println(Arrays.toString(bucket));
        // }
        return answer;
    }
}