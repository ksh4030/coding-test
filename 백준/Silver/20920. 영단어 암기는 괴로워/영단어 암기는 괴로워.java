import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();
    static String[] arr;
    public static void main(String[] args) throws IOException {
        init();
//        System.out.println(Arrays.toString(arr));
//        System.out.println(map);
        Arrays.sort(arr, (o1, o2) -> {
            if(map.get(o1) > map.get(o2)) return -1;
            else if (map.get(o1) < map.get(o2)) return 1;
            else {
                if(o1.length() > o2.length()) return -1;
                else if (o1.length() < o2.length()) return 1;
            }
            return o1.compareTo(o2);
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String s : arr) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if(s.length() < x) continue;
            int bucket = map.getOrDefault(s, 0);
            map.put(s, bucket + 1);
            if(bucket == 0) list.add(s);
        }

        Collections.sort(list);
        arr = new String[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
}