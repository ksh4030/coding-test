import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        
        for(int num : works) pq.add(num);
        
        for(int i=0; i<n; i++) {
            if(pq.isEmpty()) break;
            int bucket = pq.poll();
            if(bucket>0) pq.add(bucket - 1);
        }
        
        while(!pq.isEmpty()) {
            int bucket = pq.poll();
            answer += (bucket * bucket);
        }
                
        return answer;
    }
}