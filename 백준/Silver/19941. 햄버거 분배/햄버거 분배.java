import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String[] arr;
    static boolean[] v;
    static int N, K, cnt;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("P")) {
                isPossible(i);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    public static void isPossible(int idx) {
        int start = Math.max(0, idx - K);
        int end = Math.min(N, idx + K + 1);

        for (int i = start; i < end; i++) {
            if(arr[i].equals("H") && !v[i]) {
                v[i] = true;
                cnt++;
                return;
            }
        }
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = br.readLine().split("");
        v = new boolean[N];

        cnt = 0;
    }
}
