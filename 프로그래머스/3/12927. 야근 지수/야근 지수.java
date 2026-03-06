import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;        
        if(Arrays.stream(works).sum() <= n) return 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        for(int num : works) pq.add(num);
        
        while(n > 0) {
            pq.add(pq.poll() - 1);
            n--;
        }
        
        while(!pq.isEmpty()) {
            int num = pq.poll();
            answer += num*num;
        }
        
        return answer;
    }
}