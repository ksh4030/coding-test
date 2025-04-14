import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] dist;
    static int[] cost;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(cal());
    }

    public static long cal() {
        long sum = 0;
        long cur = cost[0];
        long d = dist[0];
        for(int i=1; i<dist.length; i++) {
            if(cost[i] < cur) {
                sum += cur * d;
                cur = cost[i];
                d = dist[i];
            } else {
                d += dist[i];
            }
        }
        sum += cur * d;
        return sum;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        dist = new int[N -1];
        for(int i=0; i<dist.length; i++) dist[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        cost = new int[N];
        for(int i=0; i<cost.length; i++) {
            int n = Integer.parseInt(st.nextToken());
            cost[i] = n;
            min = Math.min(min, n);
        }
    }

}