import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++) q.add(new Node(progresses[i], speeds[i]));
        
        while(!q.isEmpty()) {
            int n = q.size();
            int cnt = 0;
            for(int i=0; i<n; i++) {
                Node cur = q.poll();
                q.add(new Node(cur.p + cur.s, cur.s));
            }
            
            while(!q.isEmpty()) {
                if(q.peek().p >= 100) {
                    cnt++;
                    q.poll();
                } else {
                    break;
                }
            }
            if(cnt > 0) list.add(cnt);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    class Node {
        int p, s;
        public Node(int p, int s) {
            this.p = p;
            this.s = s;
        }
    }
}