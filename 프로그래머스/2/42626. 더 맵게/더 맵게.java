import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville) pq.add(n);
        
        while(true) {
            if(pq.peek() >= K) break;
            if(pq.size() < 2) return -1;
            
            int a = pq.poll();
            int b = pq.poll();
            
            int mix = a + (b*2);
            if(mix == a) return -1;
            pq.add(mix);
            answer++;
        }
        
        return answer;
    }
}