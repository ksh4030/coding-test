import java.util.*;
class Solution {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static Queue<Node> q;
    static int targetR, targetC, answer;
    static boolean[][] v;
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        v = new boolean[maps.length][maps[0].length];

        targetR = maps.length-1;
        targetC = maps[0].length-1;

        q = new LinkedList<>();
        bfs(maps);
        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        return answer;
    }
    
    public static void bfs(int[][] maps) {
        q.add(new Node(0,0,1));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == targetR && cur.c == targetC) {
                answer = Math.min(answer, cur.cnt);
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                try {
                    if(maps[nr][nc]==1 && !v[nr][nc]) {
                        q.add(new Node(nr, nc, cur.cnt+1));
                        v[nr][nc] = true;
                    }
                } catch (Exception e) {
                    continue;
                }

            }
        }
    }

    public static class Node {
        int r;
        int c;
        int cnt;
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}