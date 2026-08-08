import java.util.*;
class Solution {
    static int[][][] dp;
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        dp = new int[board.length][board[0].length][4];
        
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        
        bfs(board);
        
        for(int i=0; i<4; i++) {
            answer = Math.min(answer, dp[board.length-1][board[0].length-1][i]);
        }
        
        return answer;
    }
    
    public void bfs(int[][] board) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, -1));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0 || nc<0 || nr>=board.length || nc>=board[0].length || board[nr][nc] == 1) continue;
                int cost = cur.cost + (cur.dir == -1 || cur.dir == i ? 100 : 600);
                if(cost < dp[nr][nc][i]) {
                    dp[nr][nc][i] = cost;
                    q.add(new Node(nr, nc, cost, i));
                }
            }
        }
    }
    
    class Node {
        int r, c, cost, dir;
        public Node(int r, int c, int cost, int dir) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.dir = dir;
        }
    }
}