import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static boolean[] v;
    public int solution(String begin, String target, String[] words) {
        v = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    public void dfs(String cur, String target, String[] words, int cnt) {
        if(cur.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        if(cnt > answer) return;
        
        for(int i=0; i<words.length; i++) {
            if(!v[i] && isPossible(cur, words[i])) {
                v[i] = true;
                dfs(words[i], target, words, cnt+1);
                v[i] = false;
            }
        }
    }
    
    public boolean isPossible(String cur, String diff) {
        int cnt = 0;
        for(int i=0; i<cur.length(); i++) {
            if(cur.charAt(i) == diff.charAt(i)) cnt++;
        }
        
        return cnt + 1 == cur.length();
    }
}