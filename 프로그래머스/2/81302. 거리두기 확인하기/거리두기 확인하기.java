import java.util.*;
class Solution {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++) {
            answer[i] = checkMap(places[i]) ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean checkMap(String[] place) {
        String[][] map = new String[place.length][place[0].length()];
        for(int i=0; i<place.length; i++) map[i] = place[i].split("");
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j].equals("P")) {
                    if(!bfs(new Pos(i,j,0), map)) return false;
                }
            }
        }
        return true;
    }
    
    public boolean bfs(Pos pos, String[][] map) {
        boolean[][] v = new boolean[map.length][map[0].length];
        v[pos.r][pos.c] = true;
        Queue<Pos> q = new LinkedList<>();
        q.add(pos);
        
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            if(cur.cnt > 2) continue;
            if(cur.cnt > 0 && cur.cnt <= 2 && map[cur.r][cur.c].equals("P")) return false;
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
            
                if(nr<0 || nc<0 || nr>=map.length || nc>=map[0].length || v[nr][nc] || map[nr][nc].equals("X")) continue;
                v[nr][nc] = true;
                q.add(new Pos(nr, nc, cur.cnt+1));
            }
        }
        
        return true;
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