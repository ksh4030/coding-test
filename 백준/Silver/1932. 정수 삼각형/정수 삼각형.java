import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] pyramid;
    public static void main(String[] args) throws IOException {
        init();
        dp();
        System.out.println(pyramid[0][0]);
    }

    public static void dp() {
        for(int i=N-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                pyramid[i][j] += Math.max(pyramid[i+1][j], pyramid[i+1][j+1]);
            }
        }
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pyramid = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++) {
                pyramid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
