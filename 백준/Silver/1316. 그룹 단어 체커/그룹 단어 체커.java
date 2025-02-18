import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        int ans = 0;

        init();

        for(String s : arr) if(isPossible(s)) ans++;

        System.out.println(ans);
    }

    public static boolean isPossible(String s) {
        if(s.length() == 1) return true;

        char c = s.charAt(0);
        Map<Character, Integer> map = new HashMap<>();
        map.put(c, 1);

        for(int i=1; i<s.length(); i++) {
            char cur = s.charAt(i);

            if(c == cur) {
                map.put(cur, map.get(cur) + 1);
            } else {
                if(map.getOrDefault(cur, 0) > 0) {
                    return false;
                } else {
                    map.put(cur, 1);
                    c = cur;
                }
            }
        }

        return true;
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new String[N];

        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }
    }
}
