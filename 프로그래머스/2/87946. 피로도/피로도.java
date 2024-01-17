class Solution {
    static boolean[] v;
    static int cnt;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        v = new boolean[dungeons.length];
        cnt = 0;
        back(0, k, dungeons);

        answer = cnt;
        System.out.println(answer);
        return answer;
    }
    public static void back(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if(v[i] || dungeons[i][0] > k) {
                continue;
            }
            v[i] = true;
            back(depth+1, k-dungeons[i][1], dungeons);
            v[i] = false;
        }

        cnt = Math.max(depth, cnt);
    }
}