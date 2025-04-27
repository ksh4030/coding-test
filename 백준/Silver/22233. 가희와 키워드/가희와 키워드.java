import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        init();
    }

    public static void countWord(String[] arr) {
        for(String s : arr) set.remove(s);
        System.out.println(set.size());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) set.add(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(",");
            countWord(arr);
        }
    }
}
