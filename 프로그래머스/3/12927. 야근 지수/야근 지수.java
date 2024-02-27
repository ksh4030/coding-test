import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int a : works) {
            pq.add(a);
        }

        for (int i = 0; i < n; i++) {
            int a = pq.poll();
            if(a<=0) break;
            pq.add(a-1);
        }

        int size = pq.size();
        for (int i = 0; i < size; i++) {
            int a = pq.poll();
            answer += (a*a);
        }
        return answer;
    }
}