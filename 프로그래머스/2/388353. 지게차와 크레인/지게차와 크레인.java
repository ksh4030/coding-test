import java.util.*;
class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static String[][] map;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        makeMap(storage);
        for(String s : requests) {
            if(s.length() > 1) {
                crane(String.valueOf(s.charAt(0)));
            } else {
                car(s);
            }
        }
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(!map[i][j].equals("NONE")) answer++;
            }
        }
        
        return answer;
    }
    
    public void crane(String target) {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j].equals(target)) {
                    map[i][j] = "NONE";
                }
            }
        }
    }
    
    public void car(String target) {
        List<Pos> list = new ArrayList<>();
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j].equals(target)) {
                    list.add(new Pos(i,j));
                }
            }
        }
        
        boolean[] checked = new boolean[list.size()];
        for(int i=0; i<list.size(); i++) {
            if(isPossible(list.get(i), target)) {
                checked[i] = true;
            }
        }
        
        for(int i=0; i<checked.length; i++) {
            if(checked[i]) {
                int r = list.get(i).r;
                int c = list.get(i).c;
                map[r][c] = "NONE";
            }
        }
    }
    
    public boolean isPossible(Pos pos, String target) {
        boolean[][] v = new boolean[map.length][map[0].length];
        
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(pos.r, pos.c));
        v[pos.r][pos.c] = true;
        
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            if(cur.r == 0 || cur.c == 0 || cur.r==map.length-1 || cur.c==map[0].length-1) return true;
            
            for(int i=0; i<4; i++) {
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;
                
                if(nr>=0 && nc>=0 && nr<map.length && nc<map[0].length && !v[nr][nc] && map[nr][nc].equals("NONE")) {
                    v[nr][nc] = true;
                    q.add(new Pos(nr, nc));
                }
            }
        }
        
        return false;
    }
    
    public void makeMap(String[] storage) {
        map = new String[storage.length][storage[0].length()];
        
        for(int i=0; i<map.length; i++) {
            map[i] = storage[i].split("");
        }
    }
    
    class Pos {
        int r, c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}