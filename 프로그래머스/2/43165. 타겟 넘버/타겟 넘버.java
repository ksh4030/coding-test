import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        bfs(numbers, target);
        
        return answer;
    }
    
    public void bfs(int[] numbers, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));        
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if(cur.idx == numbers.length) {
                if(cur.sum == target) answer++;
                continue;
            }
            
            q.add(new Node(cur.sum + numbers[cur.idx], cur.idx+1));
            q.add(new Node(cur.sum - numbers[cur.idx], cur.idx+1));
        }
    }
    
    class Node {
        int sum, idx;
        public Node(int sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }
}