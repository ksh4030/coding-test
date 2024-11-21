import java.util.*;
class Solution {    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        
        for(int i=0; i<enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);
            if(n < 0) {
                while(n < 0 && !pq.isEmpty() && k > 0) {
                    n += pq.poll();
                    k--;
                }
                if(n<0) {
                    answer = i;
                    break;
                }
            }
            if(i == enemy.length-1) answer = enemy.length;
        }
        
        return answer;
    }
}