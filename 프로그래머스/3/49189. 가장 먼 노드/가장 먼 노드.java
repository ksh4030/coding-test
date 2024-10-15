import java.util.*;

class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new boolean[n+1];
        
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] arr : edge) {
            graph.get(arr[0]).add(arr[1]);
            graph.get(arr[1]).add(arr[0]);
        }
        
        answer = bfs();
        
        return answer;
    }
    
    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        visit[1] = true;
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
                if(!visit[graph.get(cur.num).get(i)]){
                    q.add(new Node(graph.get(cur.num).get(i), cur.cnt + 1));
                    visit[graph.get(cur.num).get(i)] = true;
                }
            }
        }
        return ans;
    }
    
    static class Node {
        int num, cnt;
        public Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;            
        }
    }
}