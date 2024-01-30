import java.util.*;
class Solution {
    static String[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int target;
    static Node bucket;
    public int solution(String[] maps) {
        int answer = 0;
        map = new String[maps.length][maps[0].length()];
        target = 0;
        bucket = null;

        Node start = null;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j] = String.valueOf(maps[i].charAt(j));
                if(map[i][j].equals("S")) {
                    start = new Node(i,j,0);
                }
            }
        }

        maze(start, "L");
        int check = target;
        if(bucket != null) {
            maze(bucket, "E");
            if(target == check) {
                return -1;
            }
        }
        if(target == 0) {
            return -1;
        }
        return target;
    }
    
    public static void maze(Node node, String s) {
        v = new boolean[map.length][map[0].length];
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            v[cur.r][cur.c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                try {
                    if (map[nr][nc].equals(s)) {
                        bucket = new Node(nr, nc, cur.cnt+1);
                        target = cur.cnt+1;
                        return;
                    }
                    if(!v[nr][nc] && !map[nr][nc].equals("X")) {
                        v[nr][nc] = true;
                        q.add(new Node(nr, nc, cur.cnt+1));
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }

    }
    
    static public class Node {
        int r,c,cnt;
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}