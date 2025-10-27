import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static String[][] board;
    static Node node;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new String[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            board[i] = s.split("");
        }

        findCoin();
        int ans = bfs();
        System.out.println(ans);
    }

    public static int bfs() {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        boolean[][][][] v = new boolean[N][M][N][M];
        Queue<Node> q = new LinkedList<>();
        node.cnt = 0;
        q.add(node);
        v[node.r1][node.c1][node.r2][node.c2] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.cnt >= 10) continue;
            for(int i=0; i<4; i++) {
                int nr1 = cur.r1 + dr[i];
                int nc1 = cur.c1 + dc[i];
                int nr2 = cur.r2 + dr[i];
                int nc2 = cur.c2 + dc[i];

                boolean out1 = isOut(nr1, nc1);
                boolean out2 = isOut(nr2, nc2);

                if (!out1 && board[nr1][nc1].equals("#")) {
                    nr1 = cur.r1;
                    nc1 = cur.c1;
                }
                if (!out2 && board[nr2][nc2].equals("#")) {
                    nr2 = cur.r2;
                    nc2 = cur.c2;
                }

                out1 = isOut(nr1, nc1);
                out2 = isOut(nr2, nc2);

                //둘다 떨어지면 X
                if (out1 && out2) {
                    continue;
                }
                if (out1 ^ out2) {
                    return cur.cnt + 1;
                }

                if (!v[nr1][nc1][nr2][nc2]) {
                    v[nr1][nc1][nr2][nc2] = true;
                    q.add(new Node(nr1, nc1, nr2, nc2, cur.cnt + 1));
                }
            }
        }
        return -1;
    }

    static boolean isOut(int r, int c) {
        return r < 0 || r >= N || c < 0 || c >= M;
    }

    public static void findCoin() {
        int cnt = 0;
        int sr1 = -1, sc1 = -1, sr2 = -1, sc2 = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("o")) {
                    if (cnt == 0) {
                        sr1 = i; sc1 = j; cnt++;
                    } else {
                        sr2 = i; sc2 = j;
                    }
                }
            }
        }
        node = new Node(sr1, sc1, sr2, sc2, 0);
    }

    static class Node {
        int r1, c1, r2, c2, cnt;
        Node(int r1, int c1, int r2, int c2, int cnt) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.cnt = cnt;
        }
    }
}
