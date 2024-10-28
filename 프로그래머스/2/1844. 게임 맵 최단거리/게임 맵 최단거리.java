import java.util.*;
class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static boolean[][] v;
    
    public int solution(int[][] maps) {
        v = new boolean[maps.length][maps[0].length];
        int answer = bfs(maps);        
        return answer;
    }
    
    public int bfs(int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,1));
        v[0][0] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.r == maps.length-1 && cur.c == maps[0].length-1) {
                return cur.cnt;
            }
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0 || nc<0 || nr>=maps.length || nc>=maps[0].length || maps[nr][nc]==0 || v[nr][nc]) continue;
                q.add(new Node(nr, nc, cur.cnt+1));
                v[nr][nc] = true;
            }
        }
        
        return -1;
    }
    
    class Node {
        int r, c, cnt;
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}