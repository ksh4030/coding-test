import java.util.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        for(int i=0; i<4; i++) {
            try {
                if(board[h+dr[i]][w+dc[i]].equals(board[h][w])) answer++;
            } catch(Exception e) {
                continue;
            }
        }
        
        return answer;
    }
}