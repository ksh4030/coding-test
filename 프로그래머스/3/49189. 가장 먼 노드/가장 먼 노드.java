import java.util.*;
class Solution {
    static int ans = 0;
    static int max = -1;
    static List<Integer>[] list;
    
    public int solution(int n, int[][] edge) {
        list = new ArrayList[n+1];
        init(edge);
        bfs(n);
        
        return ans;
    }
    
    public void bfs(int n) {
        Queue<Node> q = new LinkedList<>();
        boolean[] v = new boolean[n+1];
        
        q.add(new Node(1, 0));
        v[1] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if(cur.cnt > max) {
                ans = 1;
                max = cur.cnt;
            } else if (cur.cnt == max) {
                ans++;
            }
            
            for(int i=0; i<list[cur.idx].size(); i++) {
                int num = list[cur.idx].get(i);
                
                if(!v[num]) {
                    q.add(new Node(num, cur.cnt + 1));
                    v[num] = true;
                }
            }
        }
    }
    
    public void init(int[][] edge) {
        for(int i=0; i<list.length; i++) list[i] = new ArrayList<>();
        
        for(int[] arr : edge) {
            int a = arr[0];
            int b = arr[1];
            
            list[a].add(b);
            list[b].add(a);
        }
    }
    
    class Node {
        int idx, cnt;
        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}