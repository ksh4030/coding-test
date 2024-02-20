import java.util.*;
class Solution {
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visited;
    static int maxVal;
    public static void bfs(int y, int x, int m, int n, int color, int[][] picture) {
        int tmp = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {y,x});
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!queue.isEmpty()) {
                    int yy = queue.peek()[0];
                    int xx = queue.peek()[1];
                    queue.poll();
                    for (int d = 0; d < 4; d++) {
                        int ny = yy + dy[d];
                        int nx = xx + dx[d];
                        if (0 <= ny && ny < m && 0 <= nx && nx < n && !visited[ny][nx] && picture[ny][nx] == color) {
                            visited[ny][nx] = true;
                            queue.add(new int[] {ny,nx});
                            tmp++;
                        }
                    }
                }
            }
        }
        if (maxVal < tmp) maxVal = tmp;
    }
    public int[] solution(int m, int n, int[][] picture) {
        maxVal = 0;
        int[] result = new int[2];
        int cnt = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    bfs(i,j,m,n,picture[i][j],picture);
                    cnt++;
                }
            }
        }
        result[0] = cnt;
        result[1] = maxVal;
        return result;
    }

}