import java.util.*;
class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    
    static int[][] area;
    static boolean[][] v;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int num = 1;
    
    public int solution(int[][] land) {
        int answer = 0;
        init(land);
        
        for(int[] a : area) {
            System.out.println(Arrays.toString(a));
        }
        
        for(int i=0; i<area[0].length; i++) {
            answer = Math.max(findMax(i), answer);
        }
        
        return answer;
    }
    
    public int findMax(int idx) {
        int sum = 0;
        boolean[] v = new boolean[num];
        
        for(int i=0; i<area.length; i++) {
            if(area[i][idx]>0 && !v[area[i][idx]]) {
                sum += map.get(area[i][idx]);
                v[area[i][idx]] = true;
            }
        }
        
        return sum;
    }
    
    public void init(int[][] land) {
        int r = land.length;
        int c = land[0].length;
        
        area = new int[r][c];
        v = new boolean[r][c];
        
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(land[i][j]==1 && area[i][j]==0 && !v[i][j]) {
                    int size = divideArea(i, j, land);
                    map.put(num, size);
                    num++;
                }
            }
        }
    }
    
    public int divideArea(int r, int c, int[][] land) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        v[r][c] = true;
        area[r][c] = num;
        int size = 1;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for(int i=0; i<4; i++) {
                int nr = dr[i] + cur.r;
                int nc = dc[i] + cur.c;
                
                if(isPossible(nr, nc, land)) {
                    v[nr][nc] = true;
                    q.add(new Node(nr, nc));
                    area[nr][nc] = num;
                    size++;
                }
            }
        }
        
        return size;
    }
    
    public boolean isPossible(int r, int c, int[][] land) {
        if(r<0 || c<0 || r>=land.length || c>=land[0].length || land[r][c] == 0 || v[r][c]) return false;
        return true;
    }
    
    class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}