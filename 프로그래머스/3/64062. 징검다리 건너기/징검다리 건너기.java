import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int min = 0;
        int max = 200_000_000;
        
        while(min <= max) {
            int mid = (min+max) / 2;
            if(isPossible(mid, stones, k)) {
                answer = Math.max(answer, mid);
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(int mid, int[] stones, int k) {
        int cnt = 0;
        for(int i=0; i<stones.length; i++) {
            if(mid > stones[i]) cnt++;
            else cnt = 0;
            
            if(cnt == k) return false;
        }
        return true;
    }
}