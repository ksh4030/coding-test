import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    public static int bfs(int N, int target) {
        boolean[] v = new boolean[100_001];
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(N, 0));

        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            v[cur.cur] = true;
            if (cur.cur == target) {
                min = Math.min(min, cur.cnt);
                continue;
            }

            if(cur.cur+1 <= 100_000 && !v[cur.cur+1]) {
                q.add(new Pos(cur.cur+1, cur.cnt+1));
            }

            if(cur.cur-1 >= 0 && !v[cur.cur-1]) {
                q.add(new Pos(cur.cur-1, cur.cnt+1));
            }

            if(cur.cur*2 <= 100_000 && !v[cur.cur*2]) {
                q.add(new Pos(cur.cur*2, cur.cnt));
            }
        }
        return min;
    }

    static class Pos {
        int cur, cnt;

        public Pos(int cur, int cnt) {
            this.cur = cur;
            this.cnt = cnt;
        }
    }
}
