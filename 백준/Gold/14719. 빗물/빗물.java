import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int H, W;
    static int[] right, left, arr;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(cal());
    }

    public static int cal() {
        int cnt = 0;

        for(int i=0; i<W; i++) {
            cnt += Math.min(right[i], left[i]) - arr[i];
        }

        return cnt;
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[W];
        right = new int[W];
        left = new int[W];

        for(int i=0; i<W; i++) arr[i] = Integer.parseInt(st.nextToken());

        right[0] = arr[0];
        for(int i=1; i<W; i++) right[i] = Math.max(right[i-1], arr[i]);

        left[W-1] = arr[W-1];
        for(int i=W-2; i>=0; i--) {
            left[i] = Math.max(left[i+1], arr[i]);
        }
    }
}
