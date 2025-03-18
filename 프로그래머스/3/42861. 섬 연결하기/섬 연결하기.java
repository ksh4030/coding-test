import java.util.*;
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        init(n, costs);
        answer = kruskal(n, costs);
        return answer;
    }
    
    public int kruskal(int n, int[][] costs) {
        int cost = 0;
        int cnt = 0;
        for(int[] arr : costs) {
            if(union(arr[0], arr[1])) {
                cost += arr[2];
                cnt++;
                if(cnt == n-1) break;
            }
        }
        return cost;
    }
    
    public boolean union(int num1, int num2) {
        int r1 = find(num1);
        int r2 = find(num2);
        if(r1 == r2) return false;
        parent[r2] = r1;
        return true;
    }
    
    public int find(int num) {
        if(parent[num] != num) parent[num] = find(parent[num]);
        return parent[num];
    }
    
    public void init(int n, int[][] costs) {
        parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
    }
}