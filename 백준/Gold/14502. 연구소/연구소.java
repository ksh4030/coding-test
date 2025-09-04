import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int answer = 0;
    static List<int[]> viruses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 1) 입력 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2) 바이러스 위치 수집 (입력 후!)
        getVirusLocation();

        // 3) 벽 3개 세우기 - 조합으로(중복 제거)
        build(0, 0);

        System.out.println(answer);
    }

    // 벽 3개를 조합으로 세운다: idx는 0..(N*M-1)
    static void build(int depth, int start) {
        if (depth == 3) {
            // 맵 복사
            int[][] clone = new int[N][M];
            for (int i = 0; i < N; i++) clone[i] = map[i].clone();

            // 바이러스 전파
            answer = Math.max(answer, spread(clone));
            return;
        }

        for (int idx = start; idx < N * M; idx++) {
            int r = idx / M;
            int c = idx % M;
            if (map[r][c] == 0) {
                map[r][c] = 1;              // 벽 세우기
                build(depth + 1, idx + 1);  // 다음 위치부터 탐색(조합)
                map[r][c] = 0;              // 원복
            }
        }
    }

    // BFS로 바이러스 퍼뜨리기
    static int spread(int[][] clone) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();

        // 초기 바이러스 전부 넣기
        for (int[] v : viruses) {
            q.add(new int[]{v[0], v[1]});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (clone[nr][nc] != 0) continue; // 빈칸만 감염

                clone[nr][nc] = 2;
                q.add(new int[]{nr, nc}); // 큐에 추가(전파 계속)
            }
        }

        return getSafeZone(clone);
    }

    static int getSafeZone(int[][] clone) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (clone[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    static void getVirusLocation() {
        viruses.clear();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) viruses.add(new int[]{i, j});
            }
        }
    }
}
