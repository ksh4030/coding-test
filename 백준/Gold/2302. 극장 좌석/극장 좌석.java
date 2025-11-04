import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] vip = new int[M];
        for (int i = 0; i < M; i++) vip[i] = Integer.parseInt(br.readLine());

        long[] dp = new long[41];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 41; i++) dp[i] = dp[i - 2] + dp[i - 1];

        long answer = 1;
        int prev = 0;
        for (int i = 0; i < vip.length; i++) {
            int cur = vip[i] - prev - 1;
            answer *= dp[cur];
            prev = vip[i];
        }

        answer *= dp[N - prev];
        System.out.println(answer);
    }
}