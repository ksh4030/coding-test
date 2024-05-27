import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int size = times.length;
        Arrays.sort(times);
        
        long left = 0;
        long right = times[times.length - 1] * (long)n;
        long mid = 0;
        long target = 0;
        
        while(left <= right) {
            mid = (left+right) / 2;
            target = 0;
            for(int i=0; i<times.length; i++) {
                target += (mid / times[i]);
            }
            if(target < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}