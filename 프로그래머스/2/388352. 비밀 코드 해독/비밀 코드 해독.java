import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {        
        comb(1, 5, n, new ArrayList<>(), q, ans);
        
        return answer;
    }
    
    public void comb(int cur, int r, int n, List<Integer> list, int[][] q, int[] ans) {
        if(list.size() == r) {
            if(isPossible(list, q, ans)) answer++;
            return;
        }
        
        for(int i=cur; i<=n; i++) {
            list.add(i);
            comb(i+1, r, n, list, q, ans);
            list.remove(list.size()-1);
        }
    }
    
    public boolean isPossible(List<Integer> list, int[][] q, int[] ans) {
        for(int i=0; i<q.length; i++) {
            int cnt = 0;
            for(int j=0; j<q[i].length; j++) {
                if(list.contains(q[i][j])) cnt++;
            }
            if(ans[i] != cnt) return false;
        }
        return true;
    }
}