import java.util.*;
class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static String[][] map;
    static boolean[][] v;
    public int solution(String[] maps) {
        int answer = 0;
        int sum = 0;
        makeMap(maps);
                
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j].equals("S")) {
                    v = new boolean[maps.length][maps[0].length()];
                    v[i][j] = true;
                    sum = bfs(new Pos(i,j,0), "L");
                    if(sum == -1) return -1;
                    else answer = sum;
                    break;
                }
            }
        }
        sum = 0;
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j].equals("L")) {
                    v = new boolean[maps.length][maps[0].length()];
                    v[i][j] = true;
                    sum = bfs(new Pos(i,j,0), "E");
                    if(sum == -1) return -1;
                    break;
                }
            }
        }
        
        return answer + sum;
    }
    
    public int bfs(Pos pos, String target) {
        Queue<Pos> q = new LinkedList<>();
        q.add(pos);
        
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            if(map[cur.r][cur.c].equals(target))return cur.cnt;
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if(nr<0 || nc<0 || nr>=map.length || nc>=map[0].length || v[nr][nc] || map[nr][nc].equals("X")) continue;
                v[nr][nc] = true;
                q.add(new Pos(nr, nc, cur.cnt+1));
            }
        }
        return -1;
    }
    
    public void makeMap(String[] maps) {
        map = new String[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++) map[i] = maps[i].split("");
    }
    
    class Pos {
        int r, c, cnt;
        public Pos(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}