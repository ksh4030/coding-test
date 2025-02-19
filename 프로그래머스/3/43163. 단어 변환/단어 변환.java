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
            ans = Math.min(cnt, ans);
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
    
    public boolean isPossible(String cur, String diff) {
        int count = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != diff.charAt(i)) {
                count++;
            }
        }
        return count == 1; // 한 글자만 다를 경우 true 반환
    }
}