import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int money;
    static int target = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        init();
        if(Arrays.stream(arr).sum() <= money) {
            bw.write(String.valueOf(arr[arr.length-1]));
        } else {
            cal();
            bw.write(String.valueOf(target));
        }
        bw.flush();
        bw.close();
    }

    public static boolean isPossible(int mid) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < mid) {
                sum += arr[i];
            } else {
                sum += mid;
            }
        }

        return sum <= money;
    }

    public static void cal() {
        int min = 0;
        int max = arr[arr.length - 1];
        int mid = (max + min) / 2;

        while (min <= max) {
            if (isPossible(mid)) {
                target = Math.max(target, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }

            mid = (max + min) / 2;
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        money = Integer.parseInt(br.readLine());
    }
}