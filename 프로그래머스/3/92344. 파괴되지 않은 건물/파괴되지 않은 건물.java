import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] arr = new int[board.length+1][board[0].length+1];
        
        for(int[] a : skill) {
            int type = a[0];
            int r1 = a[1];
            int c1 = a[2];
            int r2 = a[3];
            int c2 = a[4];
            int damage = a[5];
            
            if(type == 1) damage = -damage;
            arr[r1][c1] += damage;
            arr[r2+1][c1] += -damage;
            arr[r1][c2+1] += -damage;
            arr[r2+1][c2+1] += damage;
        }
        
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length-1; j++) {
                arr[i][j+1] += arr[i][j];
            }
        }
        
        for(int i=0; i<arr[0].length; i++) {
            for(int j=0; j<arr.length-1; j++) {
                arr[j+1][i] += arr[j][i];
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] += arr[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}