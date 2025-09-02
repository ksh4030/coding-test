import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static Queue<Node> q = new LinkedList<>();
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        map = new int[C][R];

        for(int i=0; i<C; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<R; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) q.add(new Node(i, j, 0));
            }
        }
        bfs();
        System.out.println(isPossible() ? answer : -1);
    }

    public static void bfs() {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Node cur = q.poll();
            answer = cur.day;

            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr<0 || nc<0 || nr>=map.length || nc>=map[0].length || map[nr][nc] != 0) continue;
                q.add(new Node(nr, nc, cur.day+1));
                map[nr][nc] = 1;
            }
        }
    }
    
    public static boolean isPossible() {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }

    static class Node {
        int r, c, day;
        public Node(int r, int c, int day) {
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }
}