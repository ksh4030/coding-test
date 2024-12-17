import java.util.*;
class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int[][][] cost;
    public int solution(int[][] board) {
        int answer = 0;
        cost = new int[board.length][board[0].length][4];
        
        for(int[][] a : cost) {
            for(int[] b : a) {
                Arrays.fill(b, Integer.MAX_VALUE);
            }
        }
        
        return bfs(board);
    }
    
    public int bfs(int[][] board) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0,0,0,-1));
        cost[0][0][0] = 0;
        
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0 || nc<0 || nr>=board.length || nc>=board[0].length || board[nr][nc]==1) continue;
                int newCost = cur.cost + (cur.dir==i || cur.dir==-1 ? 100 : 600);
                if(cost[nr][nc][i] > newCost) {
                    cost[nr][nc][i] = newCost;
                    q.add(new Pos(nr, nc, newCost, i));
                }
            }
        }
        int n = Integer.MAX_VALUE;
        for(int i=0; i<4; i++){
            n = Math.min(n, cost[board.length-1][board[0].length-1][i]);
        }
        return n;
    }
    
    class Pos{
        int r, c, cost, dir;
        public Pos(int r, int c, int cost, int dir) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.dir = dir;
        }
    }
}