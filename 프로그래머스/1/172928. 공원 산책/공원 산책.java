import java.util.*;
class Solution {
    static String[][] map;
    static Node cur;
    
    static int[] dr = {0,0,1,-1}; //E W S N
    static int[] dc = {1,-1,0,0};
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        init(park);
        
        for(String s : routes) {
            boolean flag = true;
            String[] arr = s.split(" ");
            int dist = getDist(arr[0]);
            int n = Integer.parseInt(arr[1]);
            
            int nr = cur.r;
            int nc = cur.c;
            
            for(int i=0; i<n; i++) {
                nr += dr[dist];
                nc += dc[dist];
                if(nr<0 || nc<0 || nr>=map.length || nc>=map[0].length || map[nr][nc].equals("X")) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                cur = new Node(nr, nc);
            }
        }
        
        answer[0] = cur.r;
        answer[1] = cur.c;
        return answer;
    }
    
    public int getDist(String s) {
        switch(s) {
            case "E" :
                return 0;
            case "W" :
                return 1;
            case "S" :
                return 2;
            case "N" :
                return 3;                
        }
        return -1;
    }
    
    public void init(String[] park) {
        map = new String[park.length][park[0].length()];
        for(int i=0; i<map.length; i++) {
            map[i] = park[i].split("");
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j].equals("S")) cur = new Node(i, j);
            }
        }
    }
    
    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
        @Override
        public String toString() {
            return r + " " + c;
        }
    }
}