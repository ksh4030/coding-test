import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        while (!s.equals("end")) {
            String[][] board = new String[3][3];
            int idx = 0;
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    board[i][j] = String.valueOf(s.charAt(idx++));
                }
            }
            System.out.println(isValid(board) ? "valid" : "invalid");
            s = br.readLine();
        }
    }

    public static boolean isValid(String[][] board) {
        int[] arr = cntNum(board);
        int x_cnt = arr[0];
        int o_cnt = arr[1];

        boolean x_correct = checkWin(board, "X");
        boolean o_correct = checkWin(board, "O");

        if(x_cnt < o_cnt) return false;
        if(x_cnt - o_cnt >= 2) return false;
        if(x_correct && o_correct) return false;
        if(x_correct && x_cnt - o_cnt != 1) return false;
        if(!x_correct && o_correct && (x_cnt > o_cnt)) return false;
        if(!x_correct && !o_correct && checkEmpty(board)) return false;

        return true;
    }

    public static boolean checkEmpty(String[][] board) {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(board[i][j].equals(".")) return true;
            }
        }
        return false;
    }
    public static int[] cntNum(String[][] board) {
        int x = 0;
        int o = 0;

        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j].equals("X")) {
                    x++;
                } else if(board[i][j].equals("O")) {
                    o++;
                }
            }
        }
        int[] arr = new int[2];
        arr[0] = x;
        arr[1] = o;
        return arr;
    }

    public static boolean checkWin(String[][] board, String player) {
        for(int i=0; i<3; i++) {
            if(board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) return true;
        }
        for(int i=0; i<3; i++) {
            if(board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) return true;
        }
        if(board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) return true;
        if(board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) return true;
        return false;
    }
}
