import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long min = 0;
        long max = times[times.length-1] * (long)n;
        
        while(min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;
            
            for(int a : times) sum += mid/a;
            if(sum < n) {
                min = mid + 1;
            } else {
                max = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}