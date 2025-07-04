import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 0;
        int right = 200_000_000;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(isPossible(mid, stones.clone(), k)) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(int num, int[] stones, int k) {
        int cnt = 0;
        for(int i=0; i<stones.length; i++) {
            if(stones[i] < num) {
                cnt++;
            } else {
                cnt = 0;
            }
            if(cnt == k) return false;
        }
        
        return true;
    }
}