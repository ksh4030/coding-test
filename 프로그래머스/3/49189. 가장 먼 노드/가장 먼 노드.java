import java.util.*;
class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    static boolean[] v;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        v = new boolean[n+1];
        
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        for(int[] arr : edge) {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        
        return bfs();
    }
    
    public int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        v[1] = true;
        int max = 0;
        int ans = 0;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.cnt == max) ans++;
            if(cur.cnt > max) {
                ans = 1;
                max = cur.cnt;
            }
            
            for(int i=0; i<graph.get(cur.num).size(); i++) {
                int next = graph.get(cur.num).get(i);
                if(!v[next]) {
                    v[next] = true;
                    q.add(new Node(next, cur.cnt+1));
                }
            }
        }
        
        return ans;
    }
    
    class Node {
        int num, cnt;
        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}