import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Node[] arr = new Node[N];
        int[] pack = new int[K];
        boolean[] v = new boolean[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i] = new Node(w, p);
        }
        for (int i = 0; i < K; i++) pack[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Comparator.comparingInt(o -> o.w));
        Arrays.sort(pack);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;

        for (int i = 0; i < K; i++) {
            int cap = pack[i];

            while (idx < N && arr[idx].w <= cap) {
                pq.add(arr[idx].p);
                idx++;
            }

            if(!pq.isEmpty()) answer+=pq.poll();
        }

        System.out.println(answer);
    }

    static class Node {
        int w, p;
        public Node(int w, int p) {
            this.w = w;
            this.p = p;
        }
    }
}
