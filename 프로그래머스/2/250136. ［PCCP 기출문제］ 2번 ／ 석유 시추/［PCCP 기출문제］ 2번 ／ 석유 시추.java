import java.util.*;
class Solution {
    static int[][] map;
    static int idx = 1;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Map<Integer, Integer> hm = new HashMap<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        map = new int[land.length][land[0].length];
        
        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                if(land[i][j] == 1 && map[i][j] == 0) {
                    setIdx(land, i, j);
                }
            }
        }
        
        // for(int[] arr : map) System.out.println(Arrays.toString(arr));
        // System.out.println(hm);
        
        for(int i=0; i<map[0].length; i++) {
           answer = Math.max(answer, getMaxOil(i));
        }
        
        return answer;
    }
    
    public int getMaxOil(int c) {
        boolean[] v = new boolean[idx];
        int cnt = 0;
        
        for(int i=0; i<map.length; i++) {
            if(map[i][c] != 0 && !v[map[i][c]]) {
                cnt += hm.get(map[i][c]);
                v[map[i][c]] = true;
            }
        }
        
        return cnt;
    }
    
    public void setIdx(int[][] land, int r, int c) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(r, c));
        int cnt = 0;
        
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            map[cur.r][cur.c] = idx;
            cnt++;
            
            for(int i=0; i<4; i++) {
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;
                
                if(isPossible(nr, nc, land)) {
                    map[nr][nc] = idx;
                    q.add(new Pos(nr, nc));
                }
            }
        }
        
        hm.put(idx, cnt);
        idx++;
    }
    
    public boolean isPossible(int nr, int nc, int[][] land) {
        if(nr>=0 && nc>=0 && nr<land.length && nc<land[0].length && land[nr][nc] == 1 && map[nr][nc] == 0) {
            return true;
        }
        return false;
    }
    
    class Pos{
        int r, c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}