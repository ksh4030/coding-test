import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V;
    static boolean[][] board;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        init();
        v[V] = true;
        dfs(V);
        System.out.println();
        bfs();
    }
    public static void bfs() {
        v = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        v[V] = true;
        q.add(V);

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for(int i=1; i<=N; i++) {
                if(board[cur][i] && !v[i]) {
                    q.add(i);
                    v[i] = true;
                }
            }
        }
    }

    public static void dfs(int cur) {
        System.out.print(cur + " ");

        for(int i=1; i<=N; i++) {
            if(board[cur][i] && !v[i]) {
                v[i] = true;
                dfs(i);
            }
        }
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        board = new boolean[N+1][N+1];
        v = new boolean[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = true;
            board[b][a] = true;
        }
    }
}
