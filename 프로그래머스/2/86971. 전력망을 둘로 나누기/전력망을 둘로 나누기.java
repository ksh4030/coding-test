import java.util.*;
class Solution {
    static List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

         graph = new ArrayList[n+1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i = 0; i < wires.length; i++) {
            int x = wires[i][0];
            int y = wires[i][1];

            graph[x].remove(Integer.valueOf(y));
            graph[y].remove(Integer.valueOf(x));
            boolean[] v = new boolean[n+1];

            int cnt = dfs(1, v);

            int num = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, num);

            graph[x].add(y);
            graph[y].add(x);
        }
        return answer;
    }
    
    static int dfs(int n, boolean[] v) {
        v[n] = true;
        int cnt = 1;

        for (int next : graph[n]) {
            if (!v[next]) {
                cnt += dfs(next, v);
            }
        }
        return cnt;
    }
}