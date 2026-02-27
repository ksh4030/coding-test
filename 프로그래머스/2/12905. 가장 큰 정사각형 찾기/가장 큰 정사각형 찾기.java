import java.util.*;
class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        for(int i=1; i<board.length; i++) {
            for(int j=1; j<board[0].length; j++) {
                board[i][j] = board[i][j] == 0 ? 0 : Math.min(board[i-1][j], Math.min(board[i-1][j-1], board[i][j-1])) + board[i][j];
                answer = Math.max(answer, board[i][j]);
            }
        }
        
        if(answer == 0) {
            for(int i=0; i<board.length; i++) {
                if(board[i][0] == 1) return 1;
            }
            
            for(int i=0; i<board[0].length; i++) {
                if(board[0][i] == 1) return 1;
            }
        }

        return answer*answer;
    }
}