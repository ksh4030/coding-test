import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E, start;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine())-1;

        list = new List[V];
        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        boolean[] visit = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for(int cnt=0; cnt<V; cnt++) {
            int minD = Integer.MAX_VALUE;
            int minIdx = -1;

            for(int i=0; i<dist.length; i++) {
                if(!visit[i] && dist[i]<minD) {
                    minD = dist[i];
                    minIdx = i;
                }
            }
            if(minIdx == -1) {
                break;
            }
            visit[minIdx] = true;

            for(int i=0; i<list[minIdx].size(); i++) {
                if(!visit[list[minIdx].get(i).end]) {
                    dist[list[minIdx].get(i).end] = Math.min(dist[list[minIdx].get(i).end], list[minIdx].get(i).weight + minD);
                }
            }
        }

        for(int i=0; i<dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    static class Node {
        int end, weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}

