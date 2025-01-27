import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());

            HashMap<Character, List<Integer>> map = new HashMap<>();
            makeMap(map, s);
            isPossible(map, s, k);
        }
    }

    public static void isPossible(HashMap<Character, List<Integer>> map, String s, int k) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;

        for(List<Integer> list : map.values()) {
            if(list.size() < k) continue;
            for(int i=0; i<list.size()-k+1; i++) a = Math.min(a, list.get(i+k-1) - list.get(i) + 1);
            for(int i=0; i<list.size()-k+1; i++) b = Math.max(b, list.get(i+k-1) - list.get(i) + 1);
        }

        System.out.println(a == Integer.MAX_VALUE ? -1 : a + " " + b);
    }

    public static void makeMap(HashMap<Character, List<Integer>> map, String s) {
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }
    }
}
