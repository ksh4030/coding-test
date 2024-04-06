import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, cnt;
    static boolean[][] arr;
    static boolean[] check;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][N];
        check  = new boolean[N];
        q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            arr[a][b] = true;
            arr[b][a] = true;
        }

        for(int i=0; i<N; i++) {
            arr[i][i]=true;
        }

        for (int i = 0; i < N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j]) {
                    q.add(i);
                    bfs();
                }
            }
        }

        System.out.println(cnt);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int cur = q.poll();
            for(int i=0; i<N; i++) {
                if(arr[cur][i]) {
                    arr[cur][i]=false;
                    arr[i][cur]=false;
                    q.add(i);
                }
            }
        }
        cnt++;
    }
}

