import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            makeBoard(r1, r2, c1, c2);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 0) {
                    int n = bfs(new Node(i, j));
                    list.add(n);
                    answer++;
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(answer);
        System.out.println(sb);
    }

    public static void makeBoard(int r1, int r2, int c1, int c2) {
        for(int i=r1; i<r2; i++) {
            for (int j = c1; j < c2; j++) {
                board[i][j] = 1;
            }
        }
    }

    public static int bfs(Node node) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<Node> q = new LinkedList<>();
        board[node.r][node.c] = 1;
        q.add(node);
        int cnt = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            cnt++;

            for(int i=0; i<4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if(nr<0 || nc<0 || nr>=board.length || nc>=board[0].length || board[nr][nc] == 1) continue;
                q.add(new Node(nr, nc));
                board[nr][nc] = 1;
            }
        }

        return cnt;
    }

    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
