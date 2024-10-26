import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> priority = new LinkedList<>();
        Queue<Integer> num = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++) {
            priority.add(priorities[i]);
            num.add(i);
        }
        Arrays.sort(priorities);
        
        int idx = priorities.length-1;
        int cnt = 1;        
        while(!priority.isEmpty()) {
            if(priority.peek() == priorities[idx]) {
                priority.poll();
                idx--;
                int n = num.poll();
                if(n == location) return cnt;
                else cnt++;
            } else {
                priority.add(priority.poll());
                num.add(num.poll());
            }
        }
                
        return answer;
    }
}