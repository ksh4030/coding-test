import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, N;
    static String[][] arr, arr2, arr3, arr4;
    static List<Node> list = new ArrayList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new String[R][C];
        arr2 = new String[R][C];
        arr3 = new String[R][C];
        arr4 = new String[R][C];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            arr[i] = s.split("");
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j].equals("O")) {
                    list.add(new Node(i, j));
                }
                arr2[i][j] = "O";
                arr3[i][j] = "O";
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Node current = list.get(i);
            arr3[current.r][current.c] = ".";
            for(int j=0; j<4; j++) {
                int nr = current.r + dr[j];
                int nc = current.c + dc[j];

                if(nr<0 || nc<0 || nr>=R || nc>=C) {
                    continue;
                }
                arr3[nr][nc] = ".";
            }
        }
        list = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for(int j=0; j<C; j++) {
                if(arr3[i][j].equals("O")) {
                    list.add(new Node(i, j));
                }
                arr4[i][j] = "O";
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Node current = list.get(i);
            arr4[current.r][current.c] = ".";
            for(int j=0; j<4; j++) {
                int nr = current.r + dr[j];
                int nc = current.c + dc[j];

                if(nr<0 || nc<0 || nr>=R || nc>=C) {
                    continue;
                }
                arr4[nr][nc] = ".";
            }
        }


        if(N == 1) {
            print(arr);
        } else if (N % 2 == 0) {
            print(arr2);
        } else if(N%4 == 1) {
            print(arr4);
        } else if(N%4 == 3) {
            print(arr3);
        }
    }

    private static void print(String[][] arr){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
