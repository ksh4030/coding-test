import java.io.*;
import java.util.*;

public class Main {
    static String[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;
        int dist = 0;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        map = new String[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = "";
            }
        }
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = "apple";
        }

        int L = Integer.parseInt(br.readLine());
        Queue<Node> q = new LinkedList<>();

        for(int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine());
            q.add(new Node(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        map[0][0] = "snake";
        int r = 0;
        int c = 0;
        Deque<Pos> dq = new ArrayDeque<>();
        dq.add(new Pos(0 , 0));
        while (true) {
            answer++;
            r +=dr[dist];
            c +=dc[dist];
            try {
                if (map[r][c].equals("snake")) {
                    break;
                } else if (map[r][c].equals("apple")) {
                    dq.addLast(new Pos(r, c));
                    map[r][c] = "snake";
                } else {
                    if(!dq.isEmpty()){
                        Pos pos = dq.pollFirst();
                        map[pos.r][pos.c] = "";
                    }
                    dq.addLast(new Pos(r, c));
                    map[r][c] = "snake";
                }
                if(!q.isEmpty() && answer == q.peek().time) {
                    String s = q.poll().dist;
                    if(s.equals("D")) dist = (dist+1)%4;
                    else if(s.equals("L")) dist = dist - 1 < 0 ? 3 : dist-1;
                }
            } catch (Exception e) {
                break;
            }
        }

        System.out.println(answer);
    }

    static class Pos {
        int r, c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Node {
        int time;
        String dist;
        public Node(int time, String dist) {
            this.time = time;
            this.dist = dist;
        }
    }
}
