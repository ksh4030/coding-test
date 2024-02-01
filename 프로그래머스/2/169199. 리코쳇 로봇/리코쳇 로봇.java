import java.util.*;
class Solution {
        static String[][] map;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static boolean v[][];
    static int cnt;
    public int solution(String[] board) {
        int answer = 0;
        Node start = null;
        cnt = 0;

        map = new String[board.length][board[0].length()];
        v = new boolean[board.length][board[0].length()];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                map[i][j] = String.valueOf(board[i].charAt(j));
                if(map[i][j].equals("R")) {
                    start = new Node(i,j,0);
                }
            }
        }
        move(start);
        if(cnt == 0) {
            return -1;
        }
        return cnt;
    }
    
        static void move(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();
            v[cur.r][cur.c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = cur.r;
                int nc = cur.c;
                while (true) {
                    nr += dr[i];
                    nc += dc[i];
                    if(nr<0 || nc<0 || nr>=map.length || nc>=map[0].length || map[nr][nc].equals("D")) {
                        break;
                    }
                }
                nr -= dr[i];
                nc -= dc[i];
                if(map[nr][nc].equals("G")) {
                    cnt = cur.cnt+1;
                    return;
                }
                if(v[nr][nc]) continue;
                q.add(new Node(nr, nc, cur.cnt+1));
            }
        }
    }
    
    static class Node {
        int r, c, cnt;
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}