import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        for(int n : arr) {
            list = new ArrayList<>();
            bfs(n+1, 2, 1, "1", 1, "+");
            Collections.sort(list);
            for(String s : list) System.out.println(s);
            System.out.println();
        }
    }

    public static void bfs(int n, int depth, int sum, String s, int before, String beforeC) {
        if(depth == n) {
            if(sum == 0)list.add(s);
            return;
        }

        bfs(n, depth+1, sum+depth, s + "+" + String.valueOf(depth), depth, "+");
        bfs(n, depth+1, sum-depth, s + "-" + String.valueOf(depth), depth, "-");

        if(beforeC.equals("+")) {
            bfs(n, depth+1, sum-before+(10*before+depth), s+ " " + String.valueOf(depth), 10*before+depth, beforeC);
        } else {
            bfs(n, depth+1, sum+before-(10*before+depth), s+ " " + String.valueOf(depth), 10*before+depth, beforeC);
        }

    }
}