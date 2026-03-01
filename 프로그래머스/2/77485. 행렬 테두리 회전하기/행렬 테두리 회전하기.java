import java.util.*;
class Solution {
    static int[][] board;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        init(rows, columns);
        for(int i=0; i<queries.length; i++) {
            answer[i] = rotation(queries[i]);
        }
        
        return answer;
    }
    
    public int rotation(int[] arr) {
        int min = Integer.MAX_VALUE;
        int cur = board[arr[0]][arr[1]];
        int next = 0;
        
        for(int i=arr[1]; i<arr[3]; i++) {
            min = Math.min(min, cur);
            next = board[arr[0]][i+1];
            board[arr[0]][i+1] = cur;
            cur = next;
        }
        
        for(int i=arr[0]; i<arr[2]; i++) {
            min = Math.min(min, cur);
            next = board[i+1][arr[3]];
            board[i+1][arr[3]] = cur;
            cur = next;
        }
        
        for(int i=arr[3]; i>arr[1]; i--) {
            min = Math.min(min, cur);
            next = board[arr[2]][i-1];
            board[arr[2]][i-1] = cur;
            cur = next;
        }
        
        for(int i=arr[2]; i>arr[0]; i--) {
            min = Math.min(min, cur);
            next = board[i-1][arr[1]];
            board[i-1][arr[1]] = cur;
            cur = next;
        }
        
        // for(int[] b : board) {
        //     System.out.println(Arrays.toString(b));
        // }
        // System.out.println(cur);
        // System.out.println(next);
        
        return min;
    }
    
    public void init(int rows, int columns) {
        board = new int[rows+1][columns+1];
        int num = 1;
        
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                board[i][j] = num++;
            }
        }
    }
}