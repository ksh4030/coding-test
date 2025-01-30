import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        findClosestPair();
    }

    public static void findClosestPair() {
        int left = 0;
        int right = N - 1;
        int minDiff = Integer.MAX_VALUE;
        int first = 0, second = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            // 0에 더 가까운 경우 갱신
            if (Math.abs(sum) < minDiff) {
                minDiff = Math.abs(sum);
                first = arr[left];
                second = arr[right];
            }

            // sum이 0보다 크면 right를 줄이고, 작으면 left를 늘림
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(first + " " + second);
    }
}
