import java.util.*;
class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    
    static String[][] map;
    public int solution(String[] storage, String[] requests) {
        int answer = 0;

        init(storage);
        for(String s : requests) {
            if(s.length() > 1) {
                crane(String.valueOf(s.charAt(0)));
            } else {
                lift(s);
            }
        }
        
        return cntAns();
    }
    
    public int cntAns() {
        int sum = 0;
        for(String[] arr : map) {
            for(String s : arr) {
                if(!s.equals("")) sum++;
            }
        }
        return sum;
    }
    
    public void lift(String target) {
        List<Node> list = new ArrayList<>();
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j].equals(target) && isPossible(i, j)) {
                    list.add(new Node(i,j));
                }
            }
        }
        
        for(int i=0; i<list.size(); i++) {
            int r = list.get(i).r;
            int c = list.get(i).c;
            
            map[r][c] = "";
        }
    }
    
    public boolean isPossible(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r,c));
        
        boolean[][] v = new boolean[map.length][map[0].length];
        v[r][c] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;
                
                if(nr<0 || nc<0 || nr>=map.length || nc>=map[0].length) return true;
                if(!map[nr][nc].equals("") || v[nr][nc]) continue;
                v[nr][nc] = true;
                q.add(new Node(nr, nc));
            }
        }
        return false;
    }
    
    public void crane(String target) {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j].equals(target)) {
                    map[i][j] = "";
                }
            }
        }
    }
    
    public void init(String[] storage) {
        int r = storage.length;
        int c = storage[0].length();
        
        map = new String[r][c];
        for(int i=0; i<r; i++) {
            map[i] = storage[i].split("");
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