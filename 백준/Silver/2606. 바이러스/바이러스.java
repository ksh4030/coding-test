import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[N+1][N+1];
        boolean[] v = new boolean[N+1];
        v[1] = true;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = true;
            board[b][a] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i=1; i<=N; i++) {
                if(board[cur][i] && !v[i]) {
                    q.add(i);
                    v[i]= true;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}