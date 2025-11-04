import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static int[][] board;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int prev = 0;

        while (true) {
            int now = cntCheese();
            if (now == 0) break;
            prev = now;

            boolean[][] air = outsideAir();
            List<Node> q = new ArrayList<>();

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (board[i][j] == 1 && isPossible(i,j,air)) {
                        q.add(new Node(i,j));
                    }
                }
            }

            for (Node n:q) board[n.r][n.c] = 0;
            cnt++;
        }

        System.out.println(cnt);
        System.out.println(prev);
    }

    static int cntCheese() {
        int cnt = 0;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                if (board[i][j] == 1) cnt++;
        return cnt;
    }

    static boolean isPossible(int r, int c, boolean[][] air) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr<0||nc<0||nr>=R||nc>=C) continue;
            if (air[nr][nc]) return true;
        }
        return false;
    }

    static boolean[][] outsideAir() {
        boolean[][] vis = new boolean[R][C];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        vis[0][0] = true;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            for (int i=0;i<4;i++) {
                int nr=cur.r+dr[i], nc=cur.c+dc[i];
                if(nr<0||nc<0||nr>=R||nc>=C) continue;
                if(vis[nr][nc]) continue;
                if(board[nr][nc]==1) continue;
                vis[nr][nc]=true;
                q.add(new Node(nr,nc));
            }
        }
        return vis;
    }

    static class Node {
        int r,c;
        Node(int r,int c){this.r=r;this.c=c;}
    }
}
