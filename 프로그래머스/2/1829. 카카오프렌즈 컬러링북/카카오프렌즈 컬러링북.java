import java.util.*;

class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] v;
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int[][] clone;
    
    public int[] solution(int m, int n, int[][] picture) {
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        int[] answer = new int[2];

        v = new boolean[m][n];
        clone = picture.clone();
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(picture[i][j] > 0 && !v[i][j]) {
                    check(new Node(i, j, picture[i][j]));
                    numberOfArea++;
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public static void check(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        int cnt = 1;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            v[cur.r][cur.c] = true;
            for (int i = 0; i < 4; i++) {
                try {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];

                    if(cur.score == clone[nr][nc] && !v[nr][nc]) {
                        v[nr][nc] = true;
                        cnt++;
                        q.add(new Node(nr, nc, node.score));
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
    }

    static class Node {
        int r, c, score;
        public Node(int r, int c, int score) {
            this.r = r;
            this.c = c;
            this.score = score;
        }
    }
}