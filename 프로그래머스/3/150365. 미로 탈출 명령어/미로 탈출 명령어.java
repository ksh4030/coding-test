import java.util.*;
class Solution {
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    static String[] dist = {"d", "l", "r", "u"};
    StringBuilder sb = new StringBuilder();
    String ans = "impossible";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        if((Math.abs(x-r) + Math.abs(y-c))%2 != k%2) return ans;
        dfs(0, k, new Node(x-1, y-1), new Node(r-1, c-1), n, m);
        return ans;
    }
    
    public void dfs(int depth, int k, Node cur, Node end, int n, int m) {
        if(!ans.equals("impossible")) return;
        if(depth + Math.abs(cur.r - end.r) + Math.abs(cur.c - end.c) > k) return;
        if(depth == k && cur.r == end.r && cur.c == end.c) {
            ans = sb.toString();
            return;
        }
        
        for(int i=0; i<4; i++) {
            int nr = dr[i] + cur.r;
            int nc = dc[i] + cur.c;
            
            if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
            sb.append(dist[i]);
            dfs(depth+1, k, new Node(nr, nc), end, n, m);
            sb.delete(depth, depth+1);
        }
    }
    
    class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}