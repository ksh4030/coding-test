import java.util.*;
class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] v;
    static String[][] arr;
    static List<Integer> list;
    static int n;
    public int[] solution(String[] maps) {
        arr = new String[maps.length][maps[0].length()];
        v = new boolean[arr.length][arr[0].length];
        list = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            arr[i] = maps[i].split("");
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(!arr[i][j].equals("X") && !v[i][j]) {
                    n = 0;
                    v[i][j] = true;
                    n += Integer.parseInt(arr[i][j]);
                    search(new Node(i,j));
                }
            }
        }
        
        if(list.size() == 0) {
            int[] answer = {-1};
            return answer;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }
    
    public static void search(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int r = cur.r;
            int c = cur.c;

            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + r;
                int nc = dc[i] + c;

                try {
                    if(!arr[nr][nc].equals("X") && !v[nr][nc]) {
                        q.add(new Node(nr, nc));
                        n += Integer.parseInt(arr[nr][nc]);
                        v[nr][nc] = true;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
        list.add(n);
    }
    
    public static class Node {
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}