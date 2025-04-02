import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (isGood(i, arr[i])) answer++;
        }
        System.out.println(answer);
    }

    public static boolean isGood(int idx, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (left == idx) {
                left++;
                continue;
            }
            if (right == idx) {
                right--;
                continue;
            }

            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
