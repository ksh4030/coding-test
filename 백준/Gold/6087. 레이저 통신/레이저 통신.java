import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static char[][] map;
    static int W, H;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];

        List<int[]> Cs = new ArrayList<>();
        for (int r = 0; r < H; r++) {
            String s = br.readLine();
            for (int c = 0; c < W; c++) {
                map[r][c] = s.charAt(c);
                if (map[r][c] == 'C') Cs.add(new int[]{r, c});
            }
        }

        int[] S = Cs.get(0);
        int[] T = Cs.get(1);

        int INF = Integer.MAX_VALUE;
        int[][][] dist = new int[H][W][4];
        for (int r = 0; r < H; r++) for (int c = 0; c < W; c++) Arrays.fill(dist[r][c], INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(S[0], S[1], -1, 0)); // 시작: 방향 미정(-1)

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int r = cur.r, c = cur.c, dir = cur.dir, cost = cur.cost;

            if (r == T[0] && c == T[1]) {
                System.out.println(cost);
                return;
            }

            for (int nd = 0; nd < 4; nd++) {
                int nr = r + dr[nd];
                int nc = c + dc[nd];
                if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                if (map[nr][nc] == '*') continue;

                int ncost = cost + ((dir == -1 || dir == nd) ? 0 : 1);
                if (dist[nr][nc][nd] > ncost) {
                    dist[nr][nc][nd] = ncost;
                    pq.add(new Node(nr, nc, nd, ncost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int r, c, dir, cost; // dir: 0=상,1=우,2=하,3=좌, -1=시작
        Node(int r, int c, int dir, int cost) {
            this.r = r; this.c = c; this.dir = dir; this.cost = cost;
        }
        public int compareTo(Node o) { return Integer.compare(this.cost, o.cost); }
    }
}