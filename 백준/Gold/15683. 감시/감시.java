import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //1 = up
    //2 = right
    //3 = down
    //4 = left
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][][] monitor = {
            {}, // 0번은 없음
            {   // 1번 CCTV → 한 방향
                    {0}, {1}, {2}, {3}  // 상, 우, 하, 좌
            },
            {   // 2번 CCTV → 두 방향 (반대 방향)
                    {0, 2}, // 상, 하
                    {1, 3}  // 우, 좌
            },
            {   // 3번 CCTV → 두 방향 (직각)
                    {0, 1}, // 상, 우
                    {1, 2}, // 우, 하
                    {2, 3}, // 하, 좌
                    {3, 0}  // 좌, 상
            },
            {   // 4번 CCTV → 세 방향
                    {0, 1, 2}, // 상, 우, 하
                    {1, 2, 3}, // 우, 하, 좌
                    {2, 3, 0}, // 하, 좌, 상
                    {3, 0, 1}  // 좌, 상, 우
            },
            {   // 5번 CCTV → 네 방향 모두
                    {0, 1, 2, 3} // 상, 우, 하, 좌
            }
    };

    static int[][] map;
    static List<Node> list = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;
    static int R, C;
    public static void main(String[] args) throws IOException {
        init();
        bt(0);
        System.out.println(ans);
    }

    public static void bt(int idx) {
        if(idx == list.size()) {
            ans = Math.min(ans, cal());
            return;
        }
        Node cur = list.get(idx);
        int[][] bucket = copy(map);

        for(int[] arr : monitor[cur.num]) {
            watch(cur.r, cur.c, arr);
            bt(idx + 1);
            map = copy(bucket);
        }
    }

    public static int cal() {
        int cnt = 0;

        for(int i=0; i<map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }

    public static void watch(int r, int c, int[] arr) {
        for(int n : arr) {
            int nr = r;
            int nc = c;

            while (true) {
                nr += dr[n];
                nc += dc[n];
                if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc]<6) {
                    if(map[nr][nc] == 0) map[nr][nc] = -1;
                } else {
                    break;
                }
            }
        }
    }

    public static int[][] copy(int[][] map) {
        int[][] newOne = new int[R][C];
        for(int i=0; i<R; i++){
            newOne[i] = map[i].clone();
        }
        return newOne;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int n = Integer.parseInt(st.nextToken());
                map[i][j] = n;
                if(n > 0 && n < 6) {
                    list.add(new Node(i, j, n));
                }
            }
        }
    }

    static class Node {
        int r, c, num;
        public Node(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
}