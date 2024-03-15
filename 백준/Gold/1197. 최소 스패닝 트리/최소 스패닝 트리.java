import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E;
    static Node[] arr;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        arr = new Node[E];
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());
            arr[i] = new Node(start, end, weight);
        }

        Arrays.sort(arr);
        make();
        long answer = 0;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if(union(arr[i].start, arr[i].end)) {
                answer += arr[i].weight;
                cnt++;
            }
        }

        System.out.println(answer);
    }

    public static void make() {
        parents = new int[V];
        for(int i=0; i<parents.length; i++) {
            parents[i] = i;
        }
    }

    public static int find(int a) {
        if(parents[a] == a) return parents[a];
        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    static class Node implements Comparable<Node>{
        int start, end, weight;
        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
