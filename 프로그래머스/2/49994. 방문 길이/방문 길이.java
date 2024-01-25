class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] v = new boolean[11][11][4];
        String[] arr = dirs.split("");

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        int r = 5;
        int c = 5;

        for (int i = 0; i < arr.length; i++) {
            int d = 0;
            switch (arr[i]) {
                case "U" : d = 0; break;
                case "L" : d = 1; break;
                case "D" : d = 2; break;
                case "R" : d = 3; break;
            }
            int nr = r + dr[d];
            int nc = c + dc[d];

            try {
                if(!v[nr][nc][d]) {
                    v[nr][nc][d] = true;
                    if(d%2 == 0) {
                        d = 2-d;
                    } else {
                        d = 4-d;
                    }
                    v[r][c][d] = true;
                    answer++;
                }
            } catch (Exception e) {
                continue;
            }
            r = nr;
            c = nc;
        }
        return answer;
    }
}