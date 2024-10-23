import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int[] nr = {-1, 0, 1, 0};
    int[] nc = {0 , 1, 0, -1};

    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = Integer.MAX_VALUE;

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new String[R][C];

        for(int i=0; i<R; i++) {
            map[i] = br.readLine().split("");
        }

        for(int i=0; i<R-8+1; i++) {
            for(int j=0; j<C-8+1; j++) {
                String[][] bucket = new String[8][8];
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        bucket[k][l] = map[i+k][j+l];
                    }
                }

                answer = Math.min(makeNewMap(bucket), answer);
            }
        }
        System.out.println(answer);
    }

    public static int makeNewMap(String[][] bucket) {
        int a = check(bucket, 0);
        bucket[0][0] = bucket[0][0].equals("W") ? "B" : "W";
        int b = check(bucket, 1);

        return Math.min(a, b);
    }

    public static int check(String[][] bucket, int cnt) {
        String s = bucket[0][0];

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                if((i%2 == 0 && j%2 == 0) || (i%2==1 && j%2==1)) {
                    if(!bucket[i][j].equals(s)) cnt++;
                } else {
                    if(bucket[i][j].equals(s)) cnt++;
                }
            }
        }

        return cnt;
    }
}
