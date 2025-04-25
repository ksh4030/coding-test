import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer> power = new ArrayList<>();
    static int[] person;
    static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < person.length; i++) {
            sb.append(matching(i)).append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static String matching(int idx) {
        int min = 0;
        int max = power.size()-1;
        int ans = 0;

        while (min <= max) {
            int mid = (max + min) / 2;
            if(person[idx] <= power.get(mid)) {
                ans = mid;
                max = mid - 1;
            } else if (person[idx] > power.get(mid)){
                min = mid + 1;
            }
        }

        return map.get(power.get(ans));
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        person = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            if(map.getOrDefault(n, "").equals("")) {
                power.add(n);
                map.put(n, s);
            }
        }
        Collections.sort(power);
        for (int i = 0; i < M; i++) {
            person[i] = Integer.parseInt(br.readLine());
        }
    }
}
