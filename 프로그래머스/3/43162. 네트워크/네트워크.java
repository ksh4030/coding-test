class Solution {
    static boolean[] v;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        v = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!v[i]) {
                v[i] = true;
                bfs(n, i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int n, int cur, int[][] computers) {
        v[cur] = true;
        
        for(int i=0; i<n; i++) {
            if(computers[cur][i] == 1 && !v[i]) {
                bfs(n, i, computers);
            }
        }
    }
}