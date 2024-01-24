import java.util.*;
class Solution {
    static int answer;
    static String[] arr;
    static Map<Integer, Boolean> map;
    static boolean[] v;
    public int solution(String numbers) {
        answer = 0;
        arr = numbers.split("");
        v = new boolean[arr.length];
        map = new HashMap<>();

        String s = "";
        for (int i = 0; i < arr.length; i++) {
            String[] sel = new String[i+1];
            per(sel, 0);
        }
        return answer;
    }
        public static void per(String[] sel, int idx) {
        if(idx == sel.length) {
            String s = "";
            for (String value : sel) {
                s += value;
            }
            int n = Integer.parseInt(s);
            if(map.get(n) == null) {
                prime(n);
                map.put(n, true);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!v[i]) {
                v[i] = true;
                sel[idx] = arr[i];
                per(sel, idx+1);
                v[i] = false;
            }
        }
    }

    public static void prime(int n) {
        if(n < 2) return;
        if(n == 2) {
            answer++;
            return;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return;
            }
        }
        answer++;
    }
}