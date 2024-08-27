import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static String[][] map;
    static boolean[][] v;
    static Node start, end;
    static int r, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new String[r][c];
        v = new boolean[r][c];

        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().split("");
        }

        st = new StringTokenizer(br.readLine());
        start = new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0);
        st = new StringTokenizer(br.readLine());
        end = new Node(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0);

        System.out.println(bfs() ? "YES" : "NO");
    }

    public static boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        v[start.r][start.c] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for(int i=0; i<4; i++) {
                int nr = dr[i]+cur.r;
                int nc = dc[i]+cur.c;

                if(nr<0 || nc<0 || nr>=r || nc>=c ) continue;
                if(map[nr][nc].equals("X") || v[nr][nc]) {
                    if(end.r == nr && end.c == nc) return true;
                    continue;
                }

                q.add(new Node(nr, nc, 0));
                v[nr][nc] = true;
            }
        }

        return false;
    }

    static class Node {
        int r,c,cnt;
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}