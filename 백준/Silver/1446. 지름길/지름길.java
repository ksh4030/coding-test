import java.io.*;
import java.util.*;

public class Main {
    static int[] dist;
    static List<Node>[] shortcuts;
    static int N, D;

    static class Node {
        int end, weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        dp();
        System.out.println(dist[D]);
    }

    public static void dp() {
        for (int i = 0; i <= D; i++) {
            // 기본 도로: 다음 위치까지 1칸 이동
            if (i + 1 <= D) {
                dist[i + 1] = Math.min(dist[i + 1], dist[i] + 1);
            }

            // 지름길 처리
            for (Node node : shortcuts[i]) {
                if (node.end <= D) {
                    dist[node.end] = Math.min(dist[node.end], dist[i] + node.weight);
                }
            }
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // 제네릭 타입 명시
        shortcuts = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            shortcuts[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (end <= D && end - start > weight) {
                shortcuts[start].add(new Node(end, weight));
            }
        }
    }
}
