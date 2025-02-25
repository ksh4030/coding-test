import java.util.*;
class Solution {
    static Deque<Integer> dq = new ArrayDeque<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        for(String s : operations) {
            String[] bucket = s.split(" ");
            if(bucket[0].equals("I")) {                
                pq.add(Integer.parseInt(bucket[1]));
            } else {
                if(bucket[1].equals("1") && !pq.isEmpty()) {
                    while(!pq.isEmpty()) dq.addLast(pq.poll());
                    dq.removeLast();
                    while(!dq.isEmpty()) pq.add(dq.poll());
                } else if(bucket[1].equals("-1") && !pq.isEmpty()) {
                    while(!pq.isEmpty()) dq.addLast(pq.poll());
                    dq.removeFirst();
                    while(!dq.isEmpty()) pq.add(dq.poll());
                }
            }
        }
        
        if(pq.size() == 1) {
            int n = pq.poll();
            answer[0] = n;
            answer[1] = n;
        } else if (pq.size() > 1) {
            answer[1] = pq.poll();
            while(true) {
                int n = pq.poll();
                if(pq.isEmpty()) {
                    answer[0] = n;
                    break;
                }
            }
        }
        return answer;
    }    
}