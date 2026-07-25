import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int first = 1;
        int last = 100_000;
        int answer = last;
        
        while(first <= last) {
            int level = (first + last) / 2;
            long time_total = 0;
            long time_prev = 0;
            
            for(int i=0; i<diffs.length; i++) {
                if(diffs[i] > level) {
                    time_total += times[i] + ((time_prev + times[i]) * (diffs[i] - level));
                } else {
                    time_total += times[i];
                }
                time_prev = times[i];
                if(time_total > limit) break;
            }
            
            if(time_total > limit) {
                first = level + 1;
            } else {
                answer = Math.min(answer, level);
                last = level - 1;
            }
        }
        
        return answer;
    }
}