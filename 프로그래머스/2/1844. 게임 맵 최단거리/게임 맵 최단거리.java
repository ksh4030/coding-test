import java.util.*;
class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};    
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] v = new boolean[n][m];
        
        answer = bfs(n, m, v, maps);
        
        return answer;
    }
    
    public int bfs(int n, int m, boolean[][] v, int[][] maps) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 1));
        v[0][0] = true;
        
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            if(cur.r == n-1 && cur.c == m-1) return cur.cnt;
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0 || nc<0 || nr>=n || nc>=m || maps[nr][nc] == 0 || v[nr][nc]) continue;
                
                q.add(new Pos(nr, nc, cur.cnt+1));
                v[nr][nc] = true;
            }
        }
        
        return -1;
    }
    
    class Pos{
        int r, c, cnt;
        public Pos(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}