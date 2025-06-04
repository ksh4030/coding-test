import java.util.*;
class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++) {
            String[][] map = makeMap(places[i]);
            answer[i] = checkMap(map) ? 1 : 0;
        }
        
        return answer;
    }
    
    public boolean checkMap(String[][] map) {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j].equals("P")) {
                    boolean[][] v = new boolean[map.length][map[0].length];
                    if(!isPossible(i, j, v, map)) return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isPossible(int r, int c, boolean[][] v, String[][] map) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c, 0));
        v[r][c] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.cnt > 2) continue;
            if(cur.cnt != 0 && map[cur.r][cur.c].equals("P")) return false;
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0 || nc<0 || nr>=map.length || nc>=map[0].length || v[nr][nc] || map[nr][nc].equals("X")) continue;
                v[nr][nc] = true;
                q.add(new Node(nr, nc, cur.cnt+1));
            }
        }
        
        return true;
    }
    
    public String[][] makeMap(String[] place) {
        String[][] map = new String[place.length][place[0].length()];
        for(int i=0; i<place.length; i++) map[i] = place[i].split("");
        return map;
    }
    
    class Node{
        int r, c, cnt;
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}