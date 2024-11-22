import java.util.*;
class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static String[][] map;
    static int ans = -1;
    static boolean[][] v;
    public int solution(String[] board) {
        int answer = 0;
        map = new String[board.length][board[0].length()];
        v = new boolean[board.length][board[0].length()];
        
        for(int i=0; i<map.length; i++) map[i] = board[i].split("");
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j].equals("R")) {
                    bfs(new Node(i, j, 0));
                }
            }
        }
        
        return ans;
    }
    
    public void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            v[cur.r][cur.c] = true;
            if(map[cur.r][cur.c].equals("G")) {
                ans = cur.cnt;
                return;
            }
            
            for(int i=0; i<4; i++) {
                int nr = cur.r;
                int nc = cur.c;
                
                while(true) {
                    nr += dr[i];
                    nc += dc[i];
                    if(nr < 0 || nc < 0 || nr>=map.length || nc>=map[0].length || map[nr][nc].equals("D")) break;    
                }
                
                nr -= dr[i];
                nc -= dc[i];
                
                if(v[nr][nc]) continue;
                q.add(new Node(nr, nc, cur.cnt+1));
            }
        }
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