import java.util.*;
class Solution {
    int[][] board;
    public int solution(int n, int[][] results) {
        int answer = 0;
        init(n, results);
        fw(n);
        
        for(int i=1; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=n; j++) {
                if(i == j) continue;
                if(board[i][j] != 0) cnt++;
            }
            if(cnt == n - 1) answer++;
        }
        
        return answer;
    }
    
    public void fw(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    if(board[i][j] == 1 && board[j][k] == 1) {
                        board[i][k] = 1;
                        board[k][i] = -1;
                    } else if (board[i][j] == -1 && board[j][k] == -1) {
                        board[i][k] = -1;
                        board[k][i] = 1;
                    }
                }
            }
        }
    }
    
    public void init(int n, int[][] results) {
        board = new int[n+1][n+1];
        
        for(int[] arr : results) {
            int win = arr[0];
            int lose = arr[1];
            
            board[win][lose] = 1;
            board[lose][win] = -1;
        }
    }
}