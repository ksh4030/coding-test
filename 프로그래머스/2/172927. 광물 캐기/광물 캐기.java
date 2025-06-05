import java.util.*;
class Solution {
    static int[][] tired = {{1,1,1}, {5,1,1}, {25,5,1}};
    static int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        dfs(0,0, picks, minerals);
        return answer;
    }
    
    public void dfs(int idx, int sum, int[] picks, String[] minerals) {
        if(idx >= minerals.length) {
            answer = Math.min(sum, answer);
            return;
        }
        
        if(Arrays.stream(picks).sum() == 0) {
            answer = Math.min(sum, answer);
            return;
        }
        
        for(int i=0; i<3; i++) {
            if(picks[i] > 0) {
                picks[i]--;
                int n = cal(idx, idx+5>=minerals.length ? minerals.length : idx+5, minerals, i);
                dfs(idx+5, sum+n, picks, minerals);
                picks[i]++;
            }
        }
    }
    
    public int cal(int start, int end, String[] minerals, int cur) {
        int sum = 0;
        
        for(int i=start; i<end; i++) {
            switch(minerals[i]) {
                case "diamond" :
                    sum += tired[cur][0];
                    break;
                case "iron" :
                    sum += tired[cur][1];
                    break;
                case "stone" :
                    sum += tired[cur][2];
                    break;
            }
        }
        
        return sum;
    }
    
}