class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        String[][] map = new String[park.length][park[0].length()];
        int R = map.length;
        int C = map[0].length;
        Node cur = new Node(-1, -1);
        
        for(int i=0; i<park.length; i++) {
            map[i] = park[i].split("");
        }
        
        loop:
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j].equals("S")) {
                    cur = new Node(i,j);
                    break loop;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++) {
            String[] bucket = routes[i].split(" ");
            
            int dist = -1;            
            switch(bucket[0]){
                case "N" :
                    dist = 0;
                    break;
                case "S" :
                    dist = 1;
                    break;
                case "W" :
                    dist = 2;
                    break;
                case "E" :
                    dist = 3;
                    break;
            }
            
            int nr = cur.r;
            int nc = cur.c;
            boolean flag = true;
            
            for(int j=0; j<Integer.parseInt(bucket[1]); j++) {
                nr += dr[dist];
                nc += dc[dist];
                
                if(nr>=R || nc>=C || nr<0 || nc<0 || map[nr][nc].equals("X")) {
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
    
    public class Node {
        int r, c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}