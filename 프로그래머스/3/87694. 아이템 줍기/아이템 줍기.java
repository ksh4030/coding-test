import java.util.*;
class Solution {
    static int[][] map = new int[101][101];
    static boolean[][] v = new boolean[101][101];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        makeMap(rectangle);        
        
        return bfs(characterX, characterY, itemX, itemY)/2;
    }
    
    public int bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<Node> q = new ArrayDeque<>();
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        q.add(new Node(characterX, characterY, 0));
        v[characterX][characterY] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.r == itemX && cur.c == itemY) return cur.cnt;
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0 || nc<0 || nr>=map.length || nc>=map[0].length || map[nr][nc] != 1 || v[nr][nc]) continue;
                q.add(new Node(nr, nc, cur.cnt+1));
                v[nr][nc] = true;
            }
        }
        
        return -1;
    }
    
    public void makeMap(int[][] rectangle) {
        for(int[] arr : rectangle) {
            for(int i=0; i<arr.length; i++) arr[i] *= 2;
            
            for(int i=arr[0]; i<=arr[2]; i++) {
                for(int j=arr[1]; j<=arr[3]; j++) {                    
                    if(map[i][j] == 2) continue;
                    if(i==arr[0] || i==arr[2] || j==arr[1] || j==arr[3]) {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }
    }
    
    class Node {
        int r, c, cnt;
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}