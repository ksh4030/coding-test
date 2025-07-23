import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> pqA = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder());
                
        for(int i=0; i<A.length; i++) {
            pqA.add(A[i]);
            pqB.add(B[i]);
        }
        
        int a = -1;
        int b = -1;
        while(!pqA.isEmpty() && !pqB.isEmpty()) {
            if(a == -1) a = pqA.poll();
            if(b == -1) b = pqB.poll();
            
            if(b > a) {
                answer++;
                a = -1;
                b = -1;
            } else {
                a = -1;
            }
        }
        
        return answer;
    }
}