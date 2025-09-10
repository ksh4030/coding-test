import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int w, p; // weight, price
        public Node(int w, int p) {
            this.w = w;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Node[] arr = new Node[N]; // 보석 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i] = new Node(w, p);
        }

        int[] pack = new int[K]; // 가방 용량
        for (int i = 0; i < K; i++) pack[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Comparator.comparingInt(o -> o.w)); // 보석 무게 오름차순
        Arrays.sort(pack);                                   // 가방 용량 오름차순

        // 가격 기준 최대힙
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;
        int idx = 0; // 보석 인덱스

        for (int i = 0; i < K; i++) {
            int cap = pack[i];

            // 현재 가방(cap)에 담을 수 있는 보석 후보들을 최대힙에 추가
            while (idx < N && arr[idx].w <= cap) {
                pq.add(arr[idx].p);
                idx++;
            }

            // 가장 비싼 보석 하나 선택
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
