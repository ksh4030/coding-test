import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;

        for(int i=0; i<N; i++) pq.add(Integer.parseInt(br.readLine()));

        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            int sum = x+y;

            answer += sum;
            pq.add(sum);
        }
        
        System.out.println(answer);
    }
}
