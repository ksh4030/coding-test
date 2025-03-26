import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] arr;
    static int[] dp;
    static int max = 0;

    public static void main(String[] args) throws IOException{
        init();
        dp();

        for(int num : arr) {
            System.out.println(dp[num]);
        }
    }

    public static void dp() {
        int[] nums = {1,2,3};

        dp = new int[max + 1];
        dp[0] = 1;

        for(int num : nums) {
            for(int i=num; i<=max; i++) {
                dp[i] += dp[i-num];
            }
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            max = Math.max(max, num);
        }
    }
}