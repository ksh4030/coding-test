import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // dp[n][0] = n에서 0 출력 횟수, dp[n][1] = n에서 1 출력 횟수
        int[][] dp = new int[41][2];
        dp[0][0] = 1; dp[0][1] = 0; // n=0 -> "0" 1번
        dp[1][0] = 0; dp[1][1] = 1; // n=1 -> "1" 1번
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(' ').append(dp[n][1]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
