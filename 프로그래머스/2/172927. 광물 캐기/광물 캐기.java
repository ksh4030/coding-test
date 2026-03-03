import java.util.*;
class Solution {
    static int[][] board = {
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        dfs(0, 0, picks, minerals);
        
        return answer;
    }
    
    public void dfs(int idx, int sum, int[] picks, String[] minerals) {
        if(idx >= minerals.length || Arrays.stream(picks).sum() == 0) {
            answer = Math.min(answer, sum);
            return;
        }
        
        for(int i=0; i<picks.length; i++) {
            if(picks[i] > 0) {
                picks[i]--;
                if(idx+5 >= minerals.length) {
                    dfs(idx+5, sum + cal(i, idx, minerals.length, minerals), picks, minerals);
                } else {
                    dfs(idx+5, sum + cal(i, idx, idx+5, minerals), picks, minerals);
                }
                picks[i]++;
            }
        }
        
        return;
    }
    
    public int cal(int pick, int start, int end, String[] minerals) {
        int sum = 0;
        for(int i=start; i<end; i++) {
            int mine = 0;
            if(minerals[i].equals("diamond")) {
                mine = 0;
            } else if (minerals[i].equals("iron")) {
                mine = 1;
            } else {
                mine = 2;
            }
            
            sum += board[pick][mine];
        }
        
        return sum;
    }
}