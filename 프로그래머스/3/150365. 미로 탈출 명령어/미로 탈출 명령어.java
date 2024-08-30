import java.util.*;
class Solution {
    //dlru
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    static String[] dist = {"d", "l", "r", "u"};
    static String ans = "impossible";
    static StringBuilder target = new StringBuilder();
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        if((Math.abs(x-r) + Math.abs(y-c))%2 != k%2) return ans;
        dfs(0, k, new Node(x-1, y-1), new Node(r-1, c-1), n, m);
        
        answer = ans;
        return answer;
    }
    
    public static void dfs(int depth, int k, Node cur, Node end, int n, int m) {
        if(ans != "impossible") return;
        if(depth + Math.abs(cur.r-end.r) + Math.abs(cur.c-end.c) > k) return;
        if(depth == k) {
            ans = target.toString();
            return;
        }
        
        for(int i=0; i<4; i++) {
            int nr = dr[i]+cur.r;
            int nc = dc[i]+cur.c;
            
            if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
            target.append(dist[i]);
            dfs(depth+1, k, new Node(nr, nc), end, n, m);
            target.delete(depth, depth+1);
        }
    }
    
    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}