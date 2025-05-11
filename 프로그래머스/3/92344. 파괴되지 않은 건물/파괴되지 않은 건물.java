import java.util.*;
class Solution {
    static int[][] arr;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        init(board.length, board[0].length, skill);
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] += arr[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
    
    public void init(int r, int c, int[][] skill) {
        arr = new int[r+1][c+1];
        
        for(int[] a : skill) {
            int type = a[0];
            int r1 = a[1];
            int c1 = a[2];
            int r2 = a[3];
            int c2 = a[4];
            int degree = a[5];
            
            degree = type == 1 ? -degree : degree;
            
            arr[r1][c1] += degree;
            arr[r1][c2+1] -= degree;
            arr[r2+1][c1] -= degree;
            arr[r2+1][c2+1] += degree;
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
    }
}