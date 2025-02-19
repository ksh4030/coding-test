import java.util.*;
class Solution {
    static boolean[][] board;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        makeBoard(n, wires);
        return divide(n, wires);
    }
    
    public int divide(int n, int[][] wires) {
        int ans = Integer.MAX_VALUE;
        for(int[] arr : wires) {
            board[arr[0]][arr[1]] = false;
            board[arr[1]][arr[0]] = false;
            
            int cnt = bfs(n);
            ans = Math.min(Math.abs(n - 2*cnt), ans);
            
            board[arr[0]][arr[1]] = true;
            board[arr[1]][arr[0]] = true;
        }
        return ans;
    }
    
    public int bfs(int n) {
        int cnt = 1;
        boolean[] v = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        v[1] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i=1; i<=n; i++) {
                if(board[cur][i] && !v[i]) {
                    q.add(i);
                    v[i] = true;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    public void makeBoard(int n, int[][] wires) {
        board = new boolean[n+1][n+1];
        for(int[] arr : wires) {
            board[arr[0]][arr[1]] = true;
            board[arr[1]][arr[0]] = true;
        }
    }
}