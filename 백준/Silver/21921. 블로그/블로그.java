import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int day;
    public static void main(String[] args) throws IOException {
        init();
        sw();
    }

    public static void sw() throws IOException {
        int sum = 0;
        int cnt = 1;

        for(int i=0; i<day; i++) sum += arr[i];
        int max = sum;

        for(int i=day; i<arr.length; i++) {
            sum = sum - arr[i-day] + arr[i];
            if(max < sum) {
                max = sum;
                cnt = 1;
            } else if (max == sum) {
                cnt++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(sum == 0) {
            bw.write("SAD");
        } else {
            bw.write(String.valueOf(max));
            bw.newLine();
            bw.write(String.valueOf(cnt));
        }
        bw.flush();
        bw.close();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    }
}