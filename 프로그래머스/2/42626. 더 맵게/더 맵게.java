import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville) pq.add(n);
        
        while(pq.peek() < K){    
            if(pq.size() <= 1) return -1;
            int num1 = pq.poll();
            int num2 = pq.poll();
            pq.add(num1 + (num2*2));
            answer++;            
        }
        
        return answer;
    }
}