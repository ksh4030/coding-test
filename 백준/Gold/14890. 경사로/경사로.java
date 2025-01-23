import java.util.*;

public class Main {

    public static boolean isValidPath(int[] path, int L) {
        int n = path.length;
        boolean[] used = new boolean[n]; // 경사로 설치 여부 확인

        for (int i = 0; i < n - 1; i++) {
            if (path[i] == path[i + 1]) {
                continue; // 높이가 같으면 진행
            }

            if (Math.abs(path[i] - path[i + 1]) > 1) {
                return false; // 높이 차이가 1보다 크면 경사로 설치 불가
            }

            if (path[i] < path[i + 1]) { // 오르막 경사로 설치
                if (i - L + 1 < 0) { // 범위를 벗어나는 경우
                    return false;
                }
                for (int j = i - L + 1; j <= i; j++) {
                    if (path[j] != path[i] || used[j]) {
                        return false;
                    }
                }
                for (int j = i - L + 1; j <= i; j++) {
                    used[j] = true;
                }
            } else { // 내리막 경사로 설치
                if (i + L >= n) { // 범위를 벗어나는 경우
                    return false;
                }
                for (int j = i + 1; j <= i + L; j++) {
                    if (path[j] != path[i + 1] || used[j]) {
                        return false;
                    }
                }
                for (int j = i + 1; j <= i + L; j++) {
                    used[j] = true;
                }
            }
        }

        return true;
    }

    public static int countValidPaths(int[][] grid, int L) {
        int n = grid.length;
        int count = 0;

        // 행 검사
        for (int[] row : grid) {
            if (isValidPath(row, L)) {
                count++;
            }
        }

        // 열 검사
        for (int col = 0; col < n; col++) {
            int[] column = new int[n];
            for (int row = 0; row < n; row++) {
                column[row] = grid[row][col];
            }
            if (isValidPath(column, L)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int L = scanner.nextInt();
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        System.out.println(countValidPaths(grid, L));

        scanner.close();
    }
}
