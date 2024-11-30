import java.util.*;
class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1 ,1};
    static boolean[][] v;
    static int[][] map;

    public int[] solution(String[] maps) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        v = new boolean[maps.length][maps[0].length()];
        makeMap(maps);        
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j] > 0 && !v[i][j]) {
                    v[i][j] = true;
                    int n = bfs(new Pos(i,j));
                    if(n > 0) pq.add(n);                    
                }
            }
        }
        
        int[] answer = new int[pq.size()];
        for(int i=0; i<answer.length; i++) answer[i] = pq.poll();
        return answer.length == 0 ? new int[]{-1} : answer;
    }
    
    public int bfs(Pos pos) {
        Queue<Pos> q = new LinkedList<>();
        q.add(pos);
        int sum = map[pos.r][pos.c];
        
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0 || nc<0 || nr>=map.length || nc>=map[0].length || v[nr][nc] || map[nr][nc] == 0) continue;
                v[nr][nc] = true;
                sum += map[nr][nc];
                q.add(new Pos(nr, nc));
            }
        }
        
        return sum;
    }
    
    public void makeMap(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        
        for(int i=0; i<map.length; i++) {
            String[] arr = maps[i].split("");
            for(int j=0; j<map[0].length; j++) {
                try {
                    int n = Integer.parseInt(arr[j]);
                    map[i][j] = n;
                } catch (NumberFormatException e) {
                    map[i][j] = 0;
                }
            }
        }
    }
    
    class Pos{
        int r, c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;            
        }
    }
}