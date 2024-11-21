import java.util.*;

class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;
    static Map<Character, Integer> regionSize;

    public int solution(int[][] land) {
        int answer = 0;
        int rows = land.length, cols = land[0].length;
        map = new char[rows][cols];
        visited = new boolean[rows][cols];
        regionSize = new HashMap<>();
        
        char region = 'A';
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    markRegion(i, j, region++, land);
                }
            }
        }

        for (int col = 0; col < cols; col++) {
            Set<Character> uniqueRegions = new HashSet<>();
            for (int row = 0; row < rows; row++) {
                if (map[row][col] >= 'A') {
                    uniqueRegions.add(map[row][col]);
                }
            }
            int sum = uniqueRegions.stream().mapToInt(regionSize::get).sum();
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    private void markRegion(int startRow, int startCol, char region, int[][] land) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> cells = new ArrayList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        int size = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1];
            map[r][c] = region;
            size++;
            cells.add(current);

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr >= 0 && nr < land.length && nc >= 0 && nc < land[0].length 
                    && land[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        regionSize.put(region, size);
    }
}
