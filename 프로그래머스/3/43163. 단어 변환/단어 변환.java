import java.util.*;

class Solution {
    static boolean[] v;
    static int ans = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        v = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    
    public void dfs(String cur, String target, String[] words, int cnt) {
        if(cur.equals(target)) {
            ans = Math.min(ans, cnt);
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(!v[i] && isPossible(cur, words[i])) {
                v[i] = true;
                dfs(words[i], target, words, cnt+1);
                v[i] = false;
            }
        }
    }
    
    public boolean isPossible(String s, String words) {
        int cnt = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != words.charAt(i)) {
                cnt++;
            }
        }
        
        return cnt == 1;
    }
}