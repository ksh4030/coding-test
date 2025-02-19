import java.util.*;

class Solution {
    static int N;
    static boolean[][] visited;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        visited = new boolean[N][N];

        // 1. 게임 보드의 빈칸(0) 그룹 추출
        List<List<int[]>> emptySpaces = findSpaces(game_board, 0);

        // 2. 테이블의 퍼즐 조각(1) 그룹 추출
        visited = new boolean[N][N]; // 방문 배열 초기화
        List<List<int[]>> puzzlePieces = findSpaces(table, 1);

        // 3. 퍼즐 조각을 맞춰서 배치
        boolean[] used = new boolean[puzzlePieces.size()];
        int totalFilled = 0;

        for (List<int[]> space : emptySpaces) {
            for (int i = 0; i < puzzlePieces.size(); i++) {
                if (used[i]) continue;
                List<int[]> piece = puzzlePieces.get(i);

                // 4가지 방향 회전하며 비교
                for (int r = 0; r < 4; r++) {
                    piece = rotate(piece);
                    if (matches(space, piece)) {
                        totalFilled += piece.size();
                        used[i] = true;
                        break;
                    }
                }
                if (used[i]) break;
            }
        }

        return totalFilled;
    }

    // 빈칸 또는 퍼즐 조각을 찾는 함수
    private List<List<int[]>> findSpaces(int[][] board, int target) {
        List<List<int[]>> spaces = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] == target) {
                    List<int[]> space = new ArrayList<>();
                    bfs(board, i, j, target, space);
                    spaces.add(normalize(space));
                }
            }
        }
        return spaces;
    }

    // BFS를 이용해 영역 탐색
    private void bfs(int[][] board, int x, int y, int target, List<int[]> space) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            space.add(new int[]{current[0], current[1]});

            for (int[] d : directions) {
                int nx = current[0] + d[0];
                int ny = current[1] + d[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && board[nx][ny] == target) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    // 블록을 (0,0) 기준으로 정규화하여 비교할 수 있도록 함
    private List<int[]> normalize(List<int[]> block) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] p : block) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }
        List<int[]> normalized = new ArrayList<>();
        for (int[] p : block) {
            normalized.add(new int[]{p[0] - minX, p[1] - minY});
        }
        return normalized;
    }

    // 블록을 90도 회전
    private List<int[]> rotate(List<int[]> block) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : block) {
            rotated.add(new int[]{p[1], -p[0]});
        }
        return normalize(rotated);
    }

    // 빈칸과 퍼즐 조각이 일치하는지 확인
    private boolean matches(List<int[]> space, List<int[]> piece) {
        if (space.size() != piece.size()) return false;

        space.sort(Comparator.comparingInt(a -> a[0] * 100 + a[1]));
        piece.sort(Comparator.comparingInt(a -> a[0] * 100 + a[1]));

        for (int i = 0; i < space.size(); i++) {
            if (space.get(i)[0] != piece.get(i)[0] || space.get(i)[1] != piece.get(i)[1]) {
                return false;
            }
        }
        return true;
    }
}
