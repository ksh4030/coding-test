import java.util.*;
class Solution {
    static String[][] map;
    static Node start, end;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][][] v;
    public int solution(String[] board) {
        init(board);
        return bfs();
    }
    
    public int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start.r, start.c, 0, -1));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.r == end.r && cur.c == end.c) {
                return cur.cnt;
            }
            
            for(int i=0; i<4; i++) {
                if(i == cur.dir) continue;
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                while(true) {
                    if(nr < 0 || nc<0 || nr>=map.length || nc >= map[0].length || map[nr][nc].equals("D")) {
                        nr -= dr[i];
                        nc -= dc[i];
                        break;
                    }
                    nr += dr[i];
                    nc += dc[i];
                }
                
                if(cur.r == nr && cur.c == nc) continue;
                if(!v[nr][nc][i]) {
                    v[nr][nc][i] = true;
                    q.add(new Node(nr, nc, cur.cnt+1, i));
                }
            }
        }
        return -1;
    }
    
    public void init(String[] board) {
        map = new String[board.length][board[0].length()];
        v = new boolean[board.length][board[0].length()][4];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length(); j++) {
                if(board[i].charAt(j) == 'R') start = new Node(i,j,0,0);
                if(board[i].charAt(j) == 'G') end = new Node(i,j,0,0);
                map[i][j] = String.valueOf(board[i].charAt(j));
            }
        }
    }
    
    static class Node {
        int r, c, cnt, dir;
        public Node(int r, int c, int cnt, int dir) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dir = dir;
        }
    }
}