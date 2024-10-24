import java.io.*;
import java.util.*;

public class Main {
    static String[][] map;
    static int[] dr = {0, 1, 0, -1}; // 이동 방향: 동, 남, 서, 북
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 보드 크기
        int k = Integer.parseInt(br.readLine()); // 사과 개수
        map = new String[n][n];

        initMap(n); // 맵 초기화
        placeApples(br, k); // 사과 배치

        int l = Integer.parseInt(br.readLine()); // 방향 전환 횟수
        Queue<Dir> dirs = readDirections(br, l); // 방향 전환 정보

        System.out.println(simulateSnake(n, dirs)); // 뱀 게임 시뮬레이션 결과 출력
    }

    static void initMap(int n) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], "");
        }
    }

    static void placeApples(BufferedReader br, int k) throws IOException {
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = "A"; // A는 사과를 의미
        }
    }

    static Queue<Dir> readDirections(BufferedReader br, int l) throws IOException {
        Queue<Dir> dirs = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            dirs.add(new Dir(t, d));
        }
        return dirs;
    }

    static int simulateSnake(int n, Queue<Dir> dirs) {
        Deque<Pos> snake = new ArrayDeque<>();
        snake.add(new Pos(0, 0)); // 뱀 초기 위치
        map[0][0] = "S"; // S는 뱀을 의미

        int t = 0, r = 0, c = 0, dir = 0; // 시간, 좌표, 방향
        while (true) {
            t++;
            r += dr[dir];
            c += dc[dir];

            // 게임 종료 조건
            if (r < 0 || r >= n || c < 0 || c >= n || map[r][c].equals("S")) {
                return t;
            }

            // 사과가 있는 경우
            if (map[r][c].equals("A")) {
                snake.addLast(new Pos(r, c));
                map[r][c] = "S";
            } else { // 사과가 없는 경우
                Pos tail = snake.pollFirst();
                map[tail.r][tail.c] = ""; // 꼬리 이동
                snake.addLast(new Pos(r, c));
                map[r][c] = "S";
            }

            // 방향 전환
            if (!dirs.isEmpty() && t == dirs.peek().time) {
                dir = changeDir(dir, dirs.poll().dir);
            }
        }
    }

    static int changeDir(int dir, String turn) {
        if (turn.equals("D")) return (dir + 1) % 4; // 오른쪽 회전
        return (dir + 3) % 4; // 왼쪽 회전
    }

    static class Pos {
        int r, c;
        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Dir {
        int time;
        String dir;
        Dir(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }
}
