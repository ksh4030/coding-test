import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> waitpq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        
        int time = 0;
        int cnt = 0;
        int idx = 0;
        int sum = 0;
        
        while(cnt < jobs.length) {
            while(idx < jobs.length && jobs[idx][0] <= time) {
                waitpq.add(jobs[idx++]);
            }
            
            if(!waitpq.isEmpty()) {
                int[] cur = waitpq.poll();
                time += cur[1];
                sum += time - cur[0];
                cnt++;
            } else {
                time = jobs[idx][0];
            }
        }
        
        return sum / jobs.length;
    }
}