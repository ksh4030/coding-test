import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long ans = 0;
    static int[] room;
    static int B, C;

    public static void main(String[] args) throws IOException {
        init();
        check();
        System.out.println(ans);
    }

    public static void check() {
        for(int i=0; i<room.length; i++) {
            room[i] -= B;
            ans++;

            if(room[i] > 0) {
                ans += room[i] % C == 0 ? room[i]/C : room[i]/C + 1;
            }
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        room = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) room[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }
}
