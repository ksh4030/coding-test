import java.util.*;
class Solution {
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int select = 0;
        
        parents = new int[n];
        for(int i=0; i<n; i++) parents[i] = i;
        
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        for(int[] edge : costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            
            if(find(a) != find(b)) {
                union(a, b);
                answer += cost;
                
                if(select == n-1) break;
            }
        }
        
        return answer;
    }
    
    public int find(int x) {
        if(parents[x] == x) return x;
        
        return parents[x] = find(parents[x]);
    }
    
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        parents[rootB] = rootA;
    }
}