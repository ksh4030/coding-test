import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        int answer = right;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(isPossible(mid, diffs, times, limit)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(int mid, int[] diffs, int[] times, long limit) {
        long sum = 0;
        for(int i=0; i<diffs.length; i++) {
            if(mid < diffs[i]) {
                int cnt = diffs[i] - mid;
                int time = i == 0 ? 0 : times[i] + times[i-1];
                sum += (long)(cnt * time) + times[i];
            } else {
                sum += times[i];
            }
            
            if(sum > limit) return false;
        }
        return true;
    }
}