import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[i][0] = h;
            arr[i][1] = w;
        }

        int[] ans = new int[N];
        for(int i=0; i<N; i++) {
            int cnt = 1;
            for(int j=0; j<N; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }

        for(int n : ans) {
            System.out.print(n + " ");
        }
    }
}