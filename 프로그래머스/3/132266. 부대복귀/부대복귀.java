import java.util.*;
class Solution {
    static List<Integer>[] map;
    static int[] dist;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        init(n, roads);
        
        for(int i=0; i<sources.length; i++) {
            bfs(n, destination);
        }
        getAns(answer, sources);
        return answer;
    }
    
    public void init(int n, int[][] roads) {
        map = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) {
            map[i] = new ArrayList<>();
        }
        
        for(int[] r : roads) {
            map[r[0]].add(r[1]);
            map[r[1]].add(r[0]);
        }
        
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
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
    
    public void getAns(int[] answer, int[] sources) {
        for(int i=0; i<sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
    }
    
}
