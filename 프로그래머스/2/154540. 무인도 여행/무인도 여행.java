import java.util.*;
class Solution {
    static int[][] map;
    static boolean[][] v;
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();        
        
        init(maps);
        
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j] > 0 && !v[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }
        
        if(list.size() == 0) return new int[]{-1};
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    public int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        int sum = 0;
        v[r][c] = true;
        
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            sum += map[cur.r][cur.c];            
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0 || nc<0 || nr>=map.length || nc>=map[0].length || v[nr][nc] || map[nr][nc] == 0) continue;
                q.add(new Node(nr, nc));
                v[nr][nc] = true;
            }
        }
        
        return sum;
    }
    
    public void init(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        v = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
            String[] bucket = maps[i].split("");
            for(int j=0; j<bucket.length; j++) {
                map[i][j] = bucket[j].equals("X") ? 0 : Integer.parseInt(bucket[j]);
            }
        }
    }
    
    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}