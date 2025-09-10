import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1 ,o2) -> {
            return o2 - o1;
        });

        for (int i = 0; i < N; i++) pq.add(Integer.parseInt(br.readLine()));

        while (!pq.isEmpty() && target > 0) {
            int cur = pq.poll();

            if(cur <= target) {
                int cnt = target/cur;
                answer += cnt;
                target %= cur;
            }
        }

        System.out.println(answer);
    }
}
