import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static Map<Integer, Integer> map = new HashMap<>();
    static int K;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(tp());
    }

    public static int tp() {
        int left = 0;
        int right = 0;
        int size = 0;
        int[] cnt = new int[100_001];

        while (right < arr.length) {
            while (right < arr.length && cnt[arr[right]] + 1 <= K) {
                cnt[arr[right]]++;
                right++;
            }

            size = Math.max(size, right - left);
            cnt[arr[left]]--;
            left++;
        }


        return size;
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

}