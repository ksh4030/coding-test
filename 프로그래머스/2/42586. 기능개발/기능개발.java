import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int n = (100-progresses[i]) % speeds[i] > 0 ? (100-progresses[i]) / speeds[i] + 1 : (100-progresses[i]) / speeds[i];
            q.add(n);
        }
        
        while(!q.isEmpty()) {
            int n = 1;
            int cur = q.poll();
            while(true) {
                if(!q.isEmpty() && q.peek() <= cur) {
                    n++;
                    q.poll();
                } else {
                    break;
                }
            }
            list.add(n);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}