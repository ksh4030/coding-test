import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        init();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int day = Integer.parseInt(br.readLine());
            int[] arr = new int[day];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < day; j++) arr[j] = Integer.parseInt(st.nextToken());

            trading(arr);
        }
    }

    public static void trading(int[] prices) {
        long earn = 0;  // 이익 (long형으로 해야 함: 최대 1_000_000 * 10_000)
        int max = 0; // 앞으로 최고 주가

        // 뒤에서부터 탐색
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max) {
                max = prices[i];  // 최고가 갱신
            } else {
                earn += (max - prices[i]);  // 최고가에서 현재가격을 뺀 만큼 이익
            }
        }

        System.out.println(earn);
    }
}
