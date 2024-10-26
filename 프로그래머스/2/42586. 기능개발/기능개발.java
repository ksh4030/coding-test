import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();        
        
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            q.add(new Node(progresses[i], speeds[i]));
        }
        
        while(!q.isEmpty()) {
            int size = q.size();
            int cnt = 0;
            for(int i=0; i<size; i++) {
                Node cur = q.poll();
                cur = new Node(cur.prog+cur.speed, cur.speed);
                q.add(cur);
            }
            
            for(int i=0; i<size; i++) {
                if(q.peek().prog >= 100) {
                    q.poll();
                    cnt++;
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
        int prog, speed;
        public Node(int prog, int speed) {
            this.prog = prog;
            this.speed = speed;
        }
    }
}