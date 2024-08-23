import java.util.*;

class Solution {
    static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dc = {0, 1, 0, -1};
    
    static int[][][] map;
    static boolean[][][] v;
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        
        map = new int[n][n][4];
        v = new boolean[n][n][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(map[i][j], Integer.MAX_VALUE);
            }
        }
        
        bfs(board);        
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, map[n-1][n-1][i]);
        }
        
        return answer;
    }
    
    public static void bfs(int[][] board) {
        Queue<Node> q = new LinkedList<>();
        int n = board.length;
        
        if (board[0][1] == 0) {
            q.add(new Node(0, 1, 1));
            map[0][1][1] = 100;
            v[0][1][1] = true;
        }
        if (board[1][0] == 0) {
            q.add(new Node(1, 0, 2));
            map[1][0][2] = 100;
            v[1][0][2] = true;
        }
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= n || nc >= n || board[nr][nc] == 1) continue;
                
                int cost = map[cur.r][cur.c][cur.dist];
                cost += (cur.dist == i) ? 100 : 600;
              
                if (cost < map[nr][nc][i]) {
                    map[nr][nc][i] = cost;
                    v[nr][nc][i] = true;
                    q.add(new Node(nr, nc, i));
                }
            }
        }
    }
    
    static class Node {
        int r, c, dist;
        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}
