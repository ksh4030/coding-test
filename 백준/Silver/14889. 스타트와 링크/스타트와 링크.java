import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int N;
    static int ans = Integer.MAX_VALUE;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new boolean[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0,0);
        System.out.println(ans);
    }

    public static void comb(int idx, int cnt) {
        if(cnt == N/2){
            cal();
            return;
        }

        for (int i = idx; i < N; i++) {
            if(!v[i]) {
                v[i] = true;
                comb(i+1, cnt+1);
                v[i] = false;
            }
        }
    }

    public static void cal() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(v[i] && v[j]) {
                    start += map[i][j] + map[j][i];
                } else if (!v[i] && !v[j]) {
                    link += map[i][j] + map[j][i];
                }
            }
        }

        ans = Math.min(ans, Math.abs(start-link));
        if(ans == 0){
            System.out.println(ans);
            System.exit(0);
        }
    }

}