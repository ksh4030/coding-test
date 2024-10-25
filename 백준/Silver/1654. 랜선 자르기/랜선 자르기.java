import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = -1;
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        long max = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        long min = 0;
        while (max >= min) {
            long mid = (max + min) / 2;
            int cnt = 0;
            for(int i=0; i<arr.length; i++) {
                cnt += arr[i] / mid;
            }
            if(cnt < N) {
                max = mid - 1;
            }
            if(cnt >= N) {
                answer = Math.max(answer, mid);
                min = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
