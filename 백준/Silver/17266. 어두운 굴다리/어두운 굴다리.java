import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());

        bs(N, arr);
        System.out.println(ans);
    }

    public static void bs(int N, int[] arr) {
        int left = 0;
        int right = N;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(N, arr, mid)) {
                ans = Math.min(ans, mid);
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
    }

    public static boolean isPossible(int N, int[] arr, int mid) {
        int prev = 0;

        for(int n : arr) {
            int min = n - mid;
            int max = n + mid;

            if(min > prev) return false;
            prev = Math.max(prev, max);
        }

        return prev >= N;
    }
}