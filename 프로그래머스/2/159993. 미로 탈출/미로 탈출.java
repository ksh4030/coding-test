import java.util.*;
class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static boolean[][] v;
    static Node start, bucket;
    static String[][] map;
    public int solution(String[] maps) {
        int answer = 0;
        v = new boolean[maps.length][maps[0].length()];        
        map = new String[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
            map[i] = maps[i].split("");
        }
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(map[i][j].equals("S")) {
                    start = new Node(i,j,0);
                    break;
                }
            }
        }
        
        int n = bfs(start, "L");
        if(n == -1) return -1;
        answer += n;
        
        v = new boolean[maps.length][maps[0].length()];
        n = bfs(bucket, "E");
        if(n == -1) return -1;
        answer += n;
        
        return answer;
    }
    
    public static int bfs(Node node, String target) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        v[node.r][node.c] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if(map[cur.r][cur.c].equals(target)) {
                if(target.equals("L")) bucket = new Node(cur.r, cur.c, 0);
                return cur.cnt;
            }      
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0 || nc<0 || nr>=v.length || nc>=v[0].length || v[nr][nc] || map[nr][nc].equals("X")) continue;
                v[nr][nc] = true;
                q.add(new Node(nr, nc, cur.cnt+1));
            }
        }        
        return -1;
    }
    
    static class Node {
        int r, c, cnt;
        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}