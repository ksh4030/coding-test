import java.util.*;
class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    static List<Integer> list = new ArrayList<>();
    static boolean[][] v;
    static int[][] map;
    public int[] solution(String[] maps) {        
        init(maps);
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j] > 0 && !v[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }
        
        if(list.size() == 0) return new int[]{-1};
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
    
    public int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        v[r][c] = true;
        
        int sum = map[r][c];
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(isPossible(nr, nc)) {
                    v[nr][nc] = true;
                    q.add(new Node(nr, nc));
                    sum += map[nr][nc];
                }
            }
        }
        
        return sum;
    }
    
    public boolean isPossible(int r, int c) {
        if(r<0 || c<0 || r>=map.length || c>=map[0].length || map[r][c]==0 || v[r][c]) return false;
        return true;
    }
    
    public void init(String[] maps) {
        int r = maps.length;
        int c = maps[0].length();
        
        map = new int[r][c];
        v = new boolean[r][c];
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(maps[i].charAt(j) != 'X') {
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }
    }
    
    class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}