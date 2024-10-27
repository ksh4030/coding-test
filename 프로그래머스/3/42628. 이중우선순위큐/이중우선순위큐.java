import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<operations.length; i++) {
            String[] arr = operations[i].split(" ");
            if(arr[0].equals("I")) {
                pq.add(Integer.parseInt(arr[1]));
            } else {
                if(!pq.isEmpty()) {
                    if(arr[1].equals("-1")) {
                        pq.poll();
                    } else {
                        PriorityQueue<Integer> bucket = new PriorityQueue<>();
                        int len = pq.size();
                        for(int j=0; j<len-1; j++) bucket.add(pq.poll());
                        pq = bucket;
                    }
                }
            }
        }
        
        // System.out.println(pq);
        
        if(pq.size() == 1) {            
            int n = pq.poll();
            return new int[]{n, n};
        }
        if(pq.size() > 1) answer[1] = pq.poll();
        while(pq.size() > 0) answer[0] = pq.poll();
        if(answer[1] > answer[0]) {
            int tmp = answer[1];
            answer[1] = answer[0];
            answer[0] = tmp;
        }
        return answer;
    }
}