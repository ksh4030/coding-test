import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int R, C;
    static String[][] map;
    static boolean[][] v;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        init();
        bt(new Node(0, 0, 1), map[0][0]);
        System.out.println(ans);
    }

    public static void bt(Node cur, String s) {
        ans = Math.max(cur.cnt, ans);

        for(int i=0; i<4; i++) {
            int nr = cur.r + dr[i];
            int nc = cur.c + dc[i];

            if (isPossible(nr, nc, s)) {
                v[nr][nc] = true;
                bt(new Node(nr, nc, cur.cnt+1), s+map[nr][nc]);
                v[nr][nc] = false;
            }
        }
    }

    public static boolean isPossible(int r, int c, String s) {
        if(r >= 0 && c >= 0 && r < map.length && c < map[0].length && !v[r][c]) {
            return !s.contains(map[r][c]);
        }
        return false;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];
        v = new boolean[R][C];

        for (int i = 0; i < R; i++) map[i] = br.readLine().split("");
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
