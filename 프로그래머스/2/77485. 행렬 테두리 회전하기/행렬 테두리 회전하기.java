import java.util.*;
class Solution {
    static int[][] board;
    static Deque<Integer> dq;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        board = new int[rows][columns];
        makeBoard(rows, columns);
        
        for(int i=0; i<queries.length; i++) {
            answer[i] = getMinNum(queries[i]);
        }
        // Arrays.sort(answer);
        return answer;
    }
    
    public static int getMinNum(int[] arr) {
        int minNum = Integer.MAX_VALUE;
        int[] target = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            target[i] = arr[i]-1;
        }
        
        dq = new ArrayDeque<>();
        getNum(target);
        dq.addFirst(dq.pollLast());
        // System.out.println(dq);
        int num = setNum(target);
        return num;
    }
    
    public static void getNum(int[] arr) {
        for(int i=arr[1]; i<=arr[3]; i++) {
            dq.add(board[arr[0]][i]);
        }
        for(int i=arr[0]+1; i<=arr[2]; i++) {
            dq.add(board[i][arr[3]]);
        }
        for(int i=arr[3]-1; i>=arr[1]; i--) {
            dq.add(board[arr[2]][i]);
        }
        for(int i=arr[2]-1; i>arr[0]; i--) {
            dq.add(board[i][arr[1]]);
        }
    }
    
    public static int setNum(int[] arr) {
        int minNum = Integer.MAX_VALUE;
        int n = 0;
        for(int i=arr[1]; i<=arr[3]; i++) {
            n = dq.poll();
            minNum = Math.min(n, minNum);
            board[arr[0]][i] = n;
        }
        for(int i=arr[0]+1; i<=arr[2]; i++) {
            n = dq.poll();
            minNum = Math.min(n, minNum);
            board[i][arr[3]] = n;
        }
        for(int i=arr[3]-1; i>=arr[1]; i--) {
            n = dq.poll();
            minNum = Math.min(n, minNum);
            board[arr[2]][i] = n;
        }
        for(int i=arr[2]-1; i>arr[0]; i--) {
            n = dq.poll();
            minNum = Math.min(n, minNum);
            board[i][arr[1]] = n;
        }
        
        return minNum;
    }
    
    public static void makeBoard(int row, int col) {
        int num = 1;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                board[i][j] = num++;
            }
        }
    }
    
}