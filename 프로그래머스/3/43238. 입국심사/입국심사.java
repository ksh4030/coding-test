import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 0;
        long right = times[times.length-1] * (long)n;
        long mid = 0;
        long sum = 0;
        
        while(left<=right) {
            mid = (right + left) / 2;
            sum = 0;
            for(int i=0; i<times.length; i++) sum += mid/times[i];
            if(sum >= n) {
                right = mid - 1;
                answer = mid;
            } else {                
                left = mid + 1;
            }
        }
        
        return answer;
    }
}