import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] v;
    static boolean[] ansV;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < arr.length; i++) {
            v = new boolean[N+1];
            cycle(i, i);
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int n : list) System.out.println(n);
    }

    public static void cycle(int start, int cur) {
        if(!v[cur]) {
            v[cur] = true;
            cycle(start, arr[cur]);
        } else {
            if(start == cur) {
                for(int i=1; i<=N; i++) {
                    if(v[i] && !ansV[i]) {
                        list.add(i);
                        ansV[i] = true;
                    }
                }
            }
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        ansV = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}
