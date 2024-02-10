import java.util.*;
class Solution {
        static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] v;
    static int[][] arr;
    static Map<Character, Integer> hashmap;
    public int solution(int[][] land) {
        int answer = 0;
        arr = land.clone();
        map = new char[land.length][land[0].length];
        v = new boolean[land.length][land[0].length];
        hashmap = new HashMap<>();

        char c = 'A';
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if(land[i][j] == 1 && !v[i][j]) {
                    makeMap(new Node(i,j), c);
                    c = (char)(c+1);
                }
            }
        }

        for (int i = 0; i < map[0].length; i++) {
            Set<Character> set = new HashSet<>();
            int sum = 0;
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] < 65) continue;
                set.add(map[j][i]);
            }

            for (char a : set) {
                sum += hashmap.get(a);
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    public static void makeMap(Node node, char c) {
        Queue<Node> q = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        q.add(node);
        list.add(node);
        int cnt = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            v[cur.r][cur.c] = true;
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                try {
                    if(arr[nr][nc]==1 && !v[nr][nc]) {
                        v[nr][nc] = true;
                        q.add(new Node(nr, nc));
                        list.add(new Node(nr, nc));
                        cnt++;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }

        hashmap.put(c, cnt);
        for (Node n : list) {
            map[n.r][n.c] = c;
        }

    }

    public static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}