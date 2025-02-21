import java.util.*;
class Solution {
    static boolean[] v;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        v = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!v[i]) {
                v[i] = true;
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int cur, int n, int[][] computers) {
        for(int i=0; i<n; i++) {
            if(!v[i] && computers[cur][i] == 1) {
                v[i] = true;
                dfs(i, n, computers);
            }
        }
    }
}