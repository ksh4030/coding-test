import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[][] map = new boolean[n+1][n+1];
        
        Arrays.sort(costs, (o1, o2) -> {
            return o1[2] - o2[2];
        });
                
        for(int[] arr : costs) {
            int r = arr[0];
            int c = arr[1];
            int cost = arr[2];
            
            if(!isPossible(n, r, c, map) && !map[r][c] && !map[c][r]) {
                map[r][c] = true;
                map[c][r] = true;
                answer += cost;
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(int n, int r, int c, boolean[][] map) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n];
        
        q.add(r);
        v[r] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == c) return true;
            
            for(int i=0; i<n; i++) {
                if(map[cur][i] && !v[i]) {
                    v[i] = true;
                    q.add(i);
                }
            }
        }
        
        return false;
    }
    
    class Node {
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}