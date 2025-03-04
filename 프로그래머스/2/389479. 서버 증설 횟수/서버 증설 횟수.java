import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<24; i++) {
            while(!q.isEmpty() && q.peek() <= i) {
                q.poll();
            }
            
            int req = players[i] / m;
            if(req > q.size()) {
                int tmp = req - q.size();
                answer += tmp;
                
                for(int j=0; j<tmp; j++) {
                    q.add(i + k);
                }
            }
        }
        
        return answer;
    }
}