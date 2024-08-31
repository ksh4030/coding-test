import java.util.*;

class Solution {
    static int[][] map = new int[101][101];
    static boolean[][] v = new boolean[101][101];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        for(int[] arr : rectangle) {
            for(int i=0; i<arr.length; i++) arr[i] *= 2;
            makeMap(arr);
        }
        
        answer = bfs(new Node(characterX, characterY, 0), new Node(itemX, itemY, 0));        
        return answer/2;
    }
    
    static int bfs(Node start, Node end) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) {            
            Node cur = q.poll();
            v[cur.r][cur.c] = true;
            
            if(cur.r == end.r && cur.c == end.c) {
                return cur.cnt;
            }
            
            for(int i=0; i<4; i++) {
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;
                
                if(nr<0 || nc<0 || nr>=101 || nc>=101 || v[nr][nc] || map[nr][nc]!=2) continue;
                q.add(new Node(nr, nc, cur.cnt+1));
                v[nr][nc] = true;
            }
        }
        return 0;
    }
    
    static void makeMap(int[] arr) {
        for(int i=arr[0]; i<=arr[2]; i++) {
            for(int j=arr[1]; j<=arr[3]; j++) {
                if(map[i][j] == 1) continue;
                if(i==arr[0] || i==arr[2] || j==arr[1] || j==arr[3]) {
                    map[i][j] = 2;
                } else {
                    map[i][j] = 1;
                }
            }
        }
    }
    
    static class Node {
        int r, c, cnt;
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}