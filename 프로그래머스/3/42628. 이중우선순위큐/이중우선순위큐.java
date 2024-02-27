import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt1 = 0, cnt2 = 0;
        int[] answer = new int[2];
        for (String s : operations) {
            String[] arr = s.split(" ");
            switch(arr[0]){
                case "I": pq.add(Integer.parseInt(arr[1])); break;
                case "D": if("-1".equals(arr[1])){
                    pq.poll();
                }else{
                    PriorityQueue<Integer> tpq = new PriorityQueue<>();
                    int len = pq.size();
                    for(int i=0;i<len-1;i++) tpq.add(pq.poll());
                    pq = tpq;
                    break;
                }
            }
        }

        if(pq.size()>1) answer[1] = pq.poll();
        while(pq.size()>0) answer[0] = pq.poll();
        return answer;
    }
}