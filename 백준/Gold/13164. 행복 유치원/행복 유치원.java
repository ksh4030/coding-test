import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] h = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) h[i] = Long.parseLong(st.nextToken());

        if (K >= N) {
            System.out.println(0);
            return;
        }

        long total = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N - 1; i++) {
            long d = h[i + 1] - h[i];
            total += d;
            pq.add(d);
        }

        for (int i = 0; i < K - 1; i++) {
            total -= pq.poll();
        }

        System.out.println(total);
    }
}


//Xn - X1 = (X2 - X1) + (X3 - X2) + (X4 - X3) + ... + (Xn - Xn-1)