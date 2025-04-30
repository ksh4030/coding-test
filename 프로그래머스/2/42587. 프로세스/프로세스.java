import java.util.*;
class Solution {
    static Queue<Integer> q = new LinkedList<>();
    static Map<Integer, Integer> map = new HashMap<>();
    public int solution(int[] priorities, int location) {
        int answer = 1;
        init(priorities, location);
        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        
        while(!q.isEmpty()) {
            int n = q.poll();
            
            if(map.get(n) == priorities[idx]) {
                if(n == location) {
                    return answer;
                } else {
                    answer++;
                    idx--;
                }
            } else {
                q.add(n);
            }
        }
        
        return answer;
    }
    
    public void init(int[] priorities, int location) {    
        for(int i=0; i<priorities.length; i++) {
            q.add(i);
            map.put(i, priorities[i]);
        }
    }
}