import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int left = 0;
        int right = 200_000_000;
        
        while(left<=right) {
            int mid = (left+right)/2;
            int cnt = 0;
            boolean flag = true;
            
            for(int i=0; i<stones.length; i++) {
                if(stones[i] - mid < 0) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                
                if(cnt >= k) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                answer = Math.max(mid, answer);
                left = mid+1;
            } else {
                right = mid-1;
            }
        }        
        
        return answer;
    }
}