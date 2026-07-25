import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<wires.length; i++) {
            List<Integer>[] graph = new ArrayList[n+1];
            
            for(int j=0; j<n+1; j++) {
                graph[j] = new ArrayList<>();
            }
            
            for(int k=0; k<wires.length; k++) {
                if(k == i) continue;
                int a = wires[k][0];
                int b = wires[k][1];
                
                graph[a].add(b);
                graph[b].add(a);
            }
            
            boolean[] v = new boolean[n+1];
            
            int num = dfs(1, graph, v);
            
            answer = Math.min(answer, Math.abs(num - (n - num)));
        }
        
        return answer;
    }
    
    public int dfs(int cur, List<Integer>[] graph, boolean[] v) {
        v[cur] = true;
        int cnt = 1;
        
        for(int next : graph[cur]) {
            if(!v[next]) {
                cnt += dfs(next, graph, v);
            }
        }
        
        return cnt;
    }
}