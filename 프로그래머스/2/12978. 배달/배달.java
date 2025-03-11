import java.util.*;
class Solution {
    static int[] dist;
    static List<List<Node>> graph = new ArrayList<>();
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        init(N, road);
        dijkstra();
        
        for(int i=1; i<dist.length; i++) if(dist[i] <= K) answer++;
        
        return answer;
    }
    
    public void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        pq.add(new Node(1, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int town = cur.town;
            int time = cur.time;
            if(dist[town] < time) continue;
            
            for(Node next : graph.get(town)) {
                int nextTown = next.town;
                int nextTime = next.time + time;
                
                if(dist[nextTown] > nextTime) {
                    dist[nextTown] = nextTime;
                    pq.offer(new Node(nextTown, nextTime));
                }
            }
            
        }
    }
    
    public void init(int N, int[][] road) {
        for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
        
        for(int[] arr : road) {
            graph.get(arr[0]).add(new Node(arr[1], arr[2]));
            graph.get(arr[1]).add(new Node(arr[0], arr[2]));
        }
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
    }
    
    class Node {
        int town, time;
        public Node (int town, int time) {
            this.town = town;
            this.time = time;
        }
    }
}