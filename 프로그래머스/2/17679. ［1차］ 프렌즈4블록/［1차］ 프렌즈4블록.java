import java.util.*;
class Solution {
    static String[][] map;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new String[m][n];

        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].split("");
        }

        while (true) {
            int cnt = check();
            if(cnt == 0) {
                break;
            }
            down();
            answer += cnt;
        }
        return answer;
    }
    
    public static int check() {
        Set<Node> set = new HashSet<>();

        for (int i = 0; i < map.length-1; i++) {
            for (int j = 0; j < map[i].length-1; j++) {
                if(map[i][j].equals("0")) continue;

                if(map[i][j].equals(map[i][j+1]) && map[i][j].equals(map[i+1][j+1]) && map[i][j].equals(map[i+1][j])) {
                    set.add(new Node(i,j));
                    set.add(new Node(i,j+1));
                    set.add(new Node(i+1,j));
                    set.add(new Node(i+1,j+1));
                }
            }
        }

        int cnt = 0;
        Iterator<Node> iter = set.iterator();
        while (iter.hasNext()) {
            Node cur = iter.next();
            if(map[cur.r][cur.c].equals("0")) continue;
            map[cur.r][cur.c] = "0";
            cnt++;
        }

        return cnt;
    }

    public static void down() {
        for (int i = 0; i < map[0].length; i++) {
            int cnt = 0;
            for (int j = map.length-1; j >= 0; j--) {
                if(map[j][i].equals("0")) cnt++;
                if(!map[j][i].equals("0") && cnt > 0) {
                    map[j+cnt][i] = map[j][i];
                    map[j][i]  = "0";
                }
            }
        }
    }

    static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}