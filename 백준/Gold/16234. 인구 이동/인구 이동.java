import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0 , -1};
    static int[] dc = {1, 0, - 1, 0};
    static int answer, N, L, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        answer = 0;
        int cnt = 0;

        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if(recur() > 0) {
                 cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }

    public static int recur() {
        int union = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {

                    Queue<Node> q = new LinkedList<>();
                    List<Node> list = new ArrayList<>();

                    q.add(new Node(i, j));
                    list.add(new Node(i, j));
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        Node current = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int r = current.x + dr[k];
                            int c = current.y + dc[k];

                            if(r < 0 || c < 0 || r >= N || c >= N) {
                                continue;
                            }
                            if(!visited[r][c] && Math.abs(arr[current.x][current.y] - arr[r][c]) >= L && Math.abs(arr[current.x][current.y] - arr[r][c]) <= R) {
                                q.add(new Node(r, c));
                                list.add(new Node(r, c));
                                visited[r][c] = true;
                                union++;
                            }
                        }
                    }
                    int sum = 0;
                    for(Node node : list) {
                        sum += arr[node.x][node.y];
                    }
                    int avg = sum / list.size();
                    for(Node node : list) {
                        arr[node.x][node.y] = avg;
                    }


                }
            }
        }
        for (int k = 0; k < N; k++) {
            Arrays.fill(visited[k], false);
        }
        return union;
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
