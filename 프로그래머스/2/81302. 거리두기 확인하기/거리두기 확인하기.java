import java.util.*;

class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            if (checkMap(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    public boolean checkMap(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == 'P') {
                    if (!bfs(i, j, arr)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean bfs(int r, int c, String[] map) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[map.length][map[0].length()];
        q.add(new int[]{r, c, 0});
        visited[r][c] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int distance = cur[2];
            
            if (distance > 0 && distance <= 2 && map[cr].charAt(cc) == 'P') {
                return false;
            }
            
            if (distance >= 2) continue;
            
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length() || visited[nr][nc]) continue;
                if (map[nr].charAt(nc) == 'X') continue;
                
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, distance + 1});
            }
        }
        
        return true;
    }
}
