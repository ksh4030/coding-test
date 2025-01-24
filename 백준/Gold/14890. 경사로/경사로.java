import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(checkMap());
    }

    public static int checkMap() {
        int cnt = 0;

        for(int[] row : map) {
            if(isPossible(row)) cnt++;
        }

        for(int i=0; i<N; i++) {
            int[] col = new int[N];
            for(int j=0; j<N; j++) {
                col[j] = map[j][i];
            }
            if(isPossible(col)) cnt++;
        }

        return cnt;
    }

    public static boolean isPossible(int[] arr) {
        boolean[] used = new boolean[N];

        for(int i=0; i<N - 1; i++) {
            if(arr[i] == arr[i+1]) continue;
            if(Math.abs(arr[i] - arr[i+1]) > 1) return false;

            if(arr[i] < arr[i+1]) {
                if(i - L  + 1 < 0) return false;
                for(int j=i-L+1; j<=i; j++) if(arr[j] != arr[i] || used[j]) return false;
                for(int j=i-L+1; j<=i; j++) used[j] = true;
            } else {
                if(i+L >= N) return false;
                for(int j=i+1; j<=i+L; j++) if(arr[j] != arr[i+1] || used[j]) return false;
                for (int j=i+1; j<=i+L; j++) used[j] = true;
            }
        }

        return true;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
