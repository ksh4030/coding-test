import java.util.*;
class Solution {
    static int answer = 0;
    static int[][] qArr;
    static int[] ansArr;
    public int solution(int n, int[][] q, int[] ans) {
        qArr = q;
        ansArr = ans;
        
        comb(1, n, new ArrayList<>());
        
        return answer;
    }
    
    public void comb(int cur, int n, List<Integer> list) {
        if(list.size() == 5) {
            if(isPossible(list)) answer++;
            return;
        }
        
        for(int i=cur; i<=n; i++) {
            list.add(i);
            comb(i+1, n, list);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean isPossible(List<Integer> list) {
        for(int i=0; i<qArr.length; i++) {
            int cnt = 0;
            for(int j=0; j<qArr[i].length; j++) {
                if(list.contains(qArr[i][j])) cnt++;
            }
            if(ansArr[i] != cnt) return false;
        }
        return true;
    }
}