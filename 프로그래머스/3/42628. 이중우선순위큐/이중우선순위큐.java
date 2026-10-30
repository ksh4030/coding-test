import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String s : operations) {
            String[] arr = s.split(" ");
            
            if(arr[0].equals("I")) {
                pq.add(Integer.valueOf(arr[1]));
            } else {
                if(pq.isEmpty()) continue;
                
                if(arr[1].equals("1")) {
                    int max = Collections.max(pq);
                    pq.remove(max);
                } else {
                    pq.poll();
                }
            }
        }
        
         if(pq.isEmpty()) {
             return answer;
         } else if (pq.size() == 1) {
             int num = pq.poll();
             answer[0] = num;
             answer[1] = num;
         } else {
             answer[0] = Collections.max(pq);
             answer[1] = pq.poll();             
         }
        
        return answer;
    }
}