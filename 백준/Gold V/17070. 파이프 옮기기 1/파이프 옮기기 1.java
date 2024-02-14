import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        cnt = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(arr[N-1][N-1] == 1) {
            System.out.println(0);
        } else {
            pipe(0, 1, 0);
            System.out.println(cnt);
        }
    }

    public static void pipe(int r, int c, int state) {
        try {
            if(state == 1 && (arr[r-1][c] ==1 || arr[r][c-1] == 1)) {
                return;
            }

            if(r == N-1 && c == N-1) {
                cnt++;
                return;
            }

            if(r >= N || c >= N || arr[r][c] == 1) {
                return;
            }

            if(state == 0) {
                pipe(r, c+1, 0);
                pipe(r+1, c+1, 1);
            } else if (state == 1) {
                pipe(r, c+1, 0);
                pipe(r+1, c+1, 1);
                pipe(r+1, c, 2);
            } else if (state == 2) {
                pipe(r+1, c+1, 1);
                pipe(r+1, c, 2);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }

    }
}

