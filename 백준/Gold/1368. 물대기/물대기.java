import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] W = new int[N + 1];
        for (int i = 1; i <= N; i++) W[i] = Integer.parseInt(br.readLine());

        int[][] P = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) P[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[] vis = new boolean[N+1];
        int[] dist = new int[N+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int i = 1; i <= N; i++) {
            dist[i] = W[i];
            pq.add(new Node(i, W[i]));
        }

        long total = 0;
        int picked = 0;

        while (!pq.isEmpty() && picked <= N) {
            Node cur = pq.poll();
            int u = cur.v;
            if (vis[u]) continue;
            vis[u] = true;

            picked++;
            total += cur.cost;
            
            for (int i = 1; i <= N; i++) {
                if (!vis[i] && (P[u][i] < dist[i])) {
                    dist[i] = P[u][i];
                    pq.add(new Node(i, dist[i]));
                }
            }
        }

        System.out.println(total);
    }

    static class Node implements Comparable<Node> {
        int v, cost;
        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}