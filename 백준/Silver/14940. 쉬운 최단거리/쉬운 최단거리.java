import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int[][] ans;
    static boolean[][] v;
    static Pos begin;

    public static void main(String[] args) throws IOException{
        init();
        bfs();
        check();
        for(int[] arr : ans) {
            for(int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void check() {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j] == 1 && ans[i][j] == 0) {
                    ans[i][j] = -1;
                }
            }
        }
    }

    public static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.add(begin);
        v[begin.r][begin.c] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(isPossible(nr, nc)) {
                    v[nr][nc] = true;
                    ans[nr][nc] = cur.cnt + 1;
                    q.add(new Pos(nr, nc, cur.cnt + 1));
                }
            }
        }
    }

    public static boolean isPossible(int r, int c) {
        if(r<0 || c<0 || r>=map.length || c>=map[0].length || map[r][c] == 0 || v[r][c]) return false;
        return true;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        ans = new int[r][c];
        v = new boolean[r][c];

        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if(n == 2) begin = new Pos(i, j, 0);
            }
        }
    }

    static class Pos {
        int r, c, cnt;

        public Pos(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}