import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] cogs = new int[4][8]; // 톱니바퀴 배열
    static List<Node> cmd = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        turnCog();
        System.out.println(calCogState());
    }

    public static int calCogState() {
        int answer = 0;
        answer += cogs[0][0] == 1 ? 1 : 0;
        answer += cogs[1][0] == 1 ? 2 : 0;
        answer += cogs[2][0] == 1 ? 4 : 0;
        answer += cogs[3][0] == 1 ? 8 : 0;
        return answer;
    }

    public static void turnCog() {
        for (Node command : cmd) {
            int targetCog = command.num - 1; // 톱니바퀴 번호를 0-index로 변환
            int dir = command.dir;

            // 각 톱니바퀴가 회전할 방향 (0: 회전하지 않음, 1: 시계방향, -1: 반시계방향)
            int[] directions = new int[4];
            directions[targetCog] = dir;

            // 왼쪽으로 전파
            for (int i = targetCog - 1; i >= 0; i--) {
                if (cogs[i][2] != cogs[i + 1][6]) {
                    directions[i] = -directions[i + 1];
                } else {
                    break; // 맞닿은 극이 같으면 전파 멈춤
                }
            }

            // 오른쪽으로 전파
            for (int i = targetCog + 1; i < 4; i++) {
                if (cogs[i - 1][2] != cogs[i][6]) {
                    directions[i] = -directions[i - 1];
                } else {
                    break; // 맞닿은 극이 같으면 전파 멈춤
                }
            }

            // 각 톱니바퀴 회전
            for (int i = 0; i < 4; i++) {
                if (directions[i] == 1) {
                    rotateClockwise(cogs[i]);
                } else if (directions[i] == -1) {
                    rotateCounterClockwise(cogs[i]);
                }
            }
        }
    }

    public static void rotateClockwise(int[] cog) {
        int temp = cog[7];
        for (int i = 7; i > 0; i--) {
            cog[i] = cog[i - 1];
        }
        cog[0] = temp;
    }

    public static void rotateCounterClockwise(int[] cog) {
        int temp = cog[0];
        for (int i = 0; i < 7; i++) {
            cog[i] = cog[i + 1];
        }
        cog[7] = temp;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            cogs[i] = br.readLine().chars().map(c -> c - '0').toArray();
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            cmd.add(new Node(num, dir));
        }
    }

    static class Node {
        int num, dir;

        public Node(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }
}
