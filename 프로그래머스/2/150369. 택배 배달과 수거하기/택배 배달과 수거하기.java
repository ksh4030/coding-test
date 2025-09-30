class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0L, d = 0L, p = 0L;
        
        for(int i=n-1; i>=0; i--) {
            d += deliveries[i];
            p += pickups[i];
            
            while(d > 0 || p > 0) {
                answer += (i+1)*2;
                d -= cap;
                p -= cap;
            }
        }
        
        return answer;
    }
}