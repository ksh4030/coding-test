import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        int[] arrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arrB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < arrA.length; i++) {
            a.add(arrA[i]);
            b.add(arrB[i]);
        }

        while (!a.isEmpty()) {
            answer += a.poll() * b.poll();
        }

        System.out.println(answer);
    }
}
