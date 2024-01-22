import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int N, M, arr[][], answer;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		answer = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				v[i][j] = true;
				dfs(i, j, 1, arr[i][j], v);
				v[i][j] = false;
				check(i, j);
			}
		}
		System.out.println(answer);
	}

	private static void check(int r, int c) {
		
		if (r < N - 2 && c < M - 1)
            answer = Math.max(answer, arr[r][c] + arr[r + 1][c] + arr[r + 2][c] + arr[r + 1][c + 1]);

        if (r < N - 2 && c > 0)
            answer = Math.max(answer, arr[r][c] + arr[r + 1][c] + arr[r + 2][c] + arr[r + 1][c - 1]);

        if (r < N - 1 && c < M - 2)
            answer = Math.max(answer, arr[r][c] + arr[r][c + 1] + arr[r][c + 2] + arr[r + 1][c + 1]);

        if (r > 0 && c < M - 2)
            answer = Math.max(answer, arr[r][c] + arr[r][c + 1] + arr[r][c + 2] + arr[r - 1][c + 1]);

	}

	private static void dfs(int r, int c, int cnt, int sum, boolean v[][]) {
		if (cnt == 4) {
			answer = Math.max(answer, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			try {
				if (!v[nr][nc]) {
					v[nr][nc] = true;
					dfs(nr, nc, cnt + 1, sum + arr[nr][nc], v);
					v[nr][nc] = false;
				}
			} catch (Exception e) {
				continue;
			}
		}
	}
}