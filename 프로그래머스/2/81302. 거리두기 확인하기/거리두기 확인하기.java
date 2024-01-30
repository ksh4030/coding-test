import java.util.Arrays;
class Solution {
    static String[][] map;
    static boolean[][] v;
    static boolean flag;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};
    public int[] solution(String[][] places) {
        
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            flag = false;
            map = new String[5][5];
            for (int j = 0; j < map[i].length; j++) {
                map[j] = places[i][j].split("");
            }

            loop:
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(map[j][k].equals("P")) {
                        v = new boolean[5][5];
                        dfs(0, j, k);
                        if(flag) {
                            break loop;
                        }
                    }
                }
            }
            answer[i] = flag ? 0 : 1;
        }
        return answer;
    }
    
    public static void dfs(int depth, int r, int c) {
        if (depth >= 2) {
            return;
        }
        v[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];

            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || v[nr][nc]) continue;

            if (map[nr][nc].equals("O")) dfs(depth+1, nr, nc);

            else if (map[nr][nc].equals("P")) {
                flag = true;
                return;
            }
            else if (map[nr][nc].equals("X")) {
                continue;
            }
        }
    }
}