import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dice = new int[4][3];
    static int[][] map;
    static int N, M, r, c, cntCmd;
    static int[] cmd;

    public static void main(String[] args) throws IOException {
        init();

        for(int i=0; i<cmd.length; i++) {
            switch (cmd[i]) {
                case 1:
                    east();
                    break;
                case 2:
                    west();
                    break;
                case 3:
                    north();
                    break;
                case 4:
                    south();
                    break;
            }
        }
    }

    public static void check() {
        if(map[r][c] == 0) {
            map[r][c] = dice[3][1];
        } else {
            dice[3][1] = map[r][c];
            map[r][c] = 0;
        }
    }

    public static void east() {
        if(r<0 || c+1<0 || r>=map.length || c+1>=map[0].length) return;
        int tmp = dice[1][1];
        dice[1][1] = dice[1][0];
        dice[1][0] = dice[3][1];
        dice[3][1] = dice[1][2];
        dice[1][2] = tmp;

        c+=1;
        check();
        System.out.println(dice[1][1]);
    }

    public static void west() {
        if(r<0 || c-1<0 || r>=map.length || c-1>=map[0].length) return;

        int tmp = dice[1][1];
        dice[1][1] = dice[1][2];
        dice[1][2] = dice[3][1];
        dice[3][1] = dice[1][0];
        dice[1][0] = tmp;

        c-=1;
        check();
        System.out.println(dice[1][1]);
    }

    public static void north() {
        if(r-1<0 || c<0 || r-1>=map.length || c>=map[0].length) return;

        int tmp = dice[1][1];
        dice[1][1] = dice[2][1];
        dice[2][1] = dice[3][1];
        dice[3][1] = dice[0][1];
        dice[0][1] = tmp;

        r-=1;
        check();
        System.out.println(dice[1][1]);
    }

    public static void south() {
        if(r+1<0 || c<0 || r+1>=map.length || c>=map[0].length) return;

        int tmp = dice[1][1];
        dice[1][1] = dice[0][1];
        dice[0][1] = dice[3][1];
        dice[3][1] = dice[2][1];
        dice[2][1] = tmp;

        r+=1;
        check();
        System.out.println(dice[1][1]);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        cntCmd = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cmd = new int[cntCmd];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<cntCmd; i++) {
            cmd[i] = Integer.parseInt(st.nextToken());
        }
    }
}