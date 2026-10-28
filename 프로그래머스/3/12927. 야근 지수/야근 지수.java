import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int x : works) pq.add(x);
        
        for(int i=0; i<n; i++) {
            if(pq.isEmpty()) return 0;
            int num = pq.poll() - 1;
            if(num > 0) pq.add(num);
        }
        
        while(!pq.isEmpty()) {
            int num = pq.poll();
            answer += num*num;
        }
        
        return answer;
    }
}