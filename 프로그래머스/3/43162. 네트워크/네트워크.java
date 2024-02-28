import java.util.*;

class Solution {

    public int solution(int n, int[][] computers) {
        int cnt = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(computers, visited, i);
                cnt++;
            }
        }
        return cnt;
    }
    
    private void bfs(int[][] computers, boolean[] visited, int v) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while(!queue.isEmpty()) {
            Integer w = queue.poll();
            for(int i = 0; i < computers.length; i++) {
                if(computers[w][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}