import java.util.*;
class Solution {
    static boolean[] v;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        v = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!v[i]) {
                v[i] = true;
                dfs(n, computers, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int n, int[][] computers, int idx) {
        for(int i=0; i<n; i++) {
            if(v[i] || i == idx) continue;
            
            if(computers[idx][i] == 1) {
                v[i] = true;
                dfs(n, computers, i);
            }
        }
    }
}