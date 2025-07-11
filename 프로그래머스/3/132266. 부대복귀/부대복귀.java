import java.util.*;
class Solution {
    static List<Integer>[] map;
    static int[] dist;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        init(n, roads);
        bfs(n, destination);
        
        for(int i=0; i<sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
    
    public void bfs(int n, int destination) {
        Queue<Integer> q = new LinkedList<>();
        q.add(destination);
        dist[destination] = 0;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : map[cur]) {
                if(dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
    
    public void init(int n, int[][] roads) {
        map = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++) {
            map[i] = new ArrayList<>();
        }
        
        for(int[] arr : roads) {
            map[arr[0]].add(arr[1]);
            map[arr[1]].add(arr[0]);
        }
        
        dist = new int[n+1];
        Arrays.fill(dist, -1);
    }
}