import java.util.*;
class Solution {
    static boolean[] v;
    static Set<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        v = new boolean[user_id.length];
        set = new HashSet<>();

        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
        }

        comb(0, "", user_id, banned_id);
        return set.size();
    }
    
        public static void comb(int depth, String s, String[] user_id, String[] banned_id) {
        if(depth == banned_id.length) {
            String[] arr = s.split(" ");
            Arrays.sort(arr);

            String bucket = "";
            for (String a : arr) {
                bucket += a;
            }
            set.add(bucket);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if(!v[i] && user_id[i].matches(banned_id[depth])) {
                v[i] = true;
                comb(depth+1, user_id[i]+" "+s, user_id, banned_id);
                v[i] = false;
            }
        }
    }
}