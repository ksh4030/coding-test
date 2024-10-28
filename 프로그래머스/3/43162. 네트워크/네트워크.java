class Solution {
    static int[][] map;
    static boolean[] v;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        map = computers;
        v = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!v[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int idx) {
        v[idx] = true;
        
        for(int i=0; i<map.length; i++) {
            if(map[idx][i] == 1 && !v[i]) {
                dfs(i);
            }
        }
    }
}