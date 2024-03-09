import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N;
    static String arr[][];
    static List<Node> teacher, space;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        teacher = new ArrayList<>();
        space = new ArrayList<>();
        arr = new String[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = st.nextToken();
                if(arr[i][j].equals("X")) {
                    space.add(new Node(i, j));
                } else if(arr[i][j].equals("T")) {
                    teacher.add(new Node(i, j));
                }
            }
        }

        comb(new Node[3], 0, 0);

        System.out.println("NO");
    }

    private static void comb(Node[] sel, int idx, int k) {
        if(k == sel.length) {
            if(observe(sel)) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for(int i=idx; i<space.size(); i++) {
            sel[k] = space.get(i);
            comb(sel, i+1, k+1);
        }
    }

    private static boolean observe(Node[] sel) {
        String[][] copy = new String[N][N];
        for(int i=0; i<N; i++) {
            copy[i] = arr[i].clone();
        }
        for(int i=0; i<sel.length; i++) {
            copy[sel[i].r][sel[i].c] = "O";
        }

        for(int i=0; i<teacher.size(); i++) {
            Node cur = teacher.get(i);

            for(int j=0; j<4; j++) {
                int nr = cur.r + dr[j];
                int nc = cur.c + dc[j];
                while (true) {
                    try {
                        if(copy[nr][nc].equals("S")) {
                            return false;
                        } else if (copy[nr][nc].equals("O")) {
                            break;
                        }
                    } catch (Exception e) {
                        break;
                    }
                    nr += dr[j];
                    nc += dc[j];
                }
            }
        }

        return true;
    }


    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}