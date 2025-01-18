import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] v;
    static Pos pos;
    static int cleaned = 0;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        init();
        move();
        System.out.println(cleaned);
    }

    public static void move() {
        while (true) {
            int r = pos.r;
            int c = pos.c;
            int dir = pos.dir;

            // 1. 현재 칸 청소
            if (map[r][c] == 0 && !v[r][c]) {
                cleaned++;
                v[r][c] = true;
            }

            // 2. 주변에 청소되지 않은 칸 확인
            if (isClean(r, c)) {
                // 반시계 방향으로 회전
                dir = (dir + 3) % 4;
                if (r + dr[dir] >= 0 && c + dc[dir] >= 0 && r + dr[dir] < map.length && c + dc[dir] < map[0].length &&
                        map[r + dr[dir]][c + dc[dir]] == 0 && !v[r + dr[dir]][c + dc[dir]]) {
                    // 전진
                    r += dr[dir];
                    c += dc[dir];
                }
            } else {
                // 후진
                int nDir = (dir + 2) % 4;
                if (r + dr[nDir] < 0 || c + dc[nDir] < 0 || r + dr[nDir] >= map.length || c + dc[nDir] >= map[0].length ||
                        map[r + dr[nDir]][c + dc[nDir]] == 1) {
                    break;
                }
                r += dr[nDir];
                c += dc[nDir];
            }

            pos = new Pos(r, c, dir);
        }
    }

    public static boolean isClean(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nc >= 0 && nr < map.length && nc < map[0].length &&
                    map[nr][nc] == 0 && !v[nr][nc]) {
                return true;
            }
        }
        return false;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        pos = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Pos {
        int r, c, dir;

        public Pos(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
}
