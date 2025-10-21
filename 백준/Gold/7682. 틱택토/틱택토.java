import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = br.readLine()).equals("end")) {
            System.out.println(isPossible(s) ? "valid" : "invalid");
        }
    }

    static boolean isPossible(String s) {
        char[] board = s.toCharArray();
        int cntX = 0;
        int cntO = 0;

        for (char c : board) {
            if (c == 'X') cntX++;
            else if (c == 'O') cntO++;
        }

        if (!(cntX == cntO || cntX == cntO + 1)) return false;

        boolean xWin = win(board, 'X');
        boolean oWin = win(board, 'O');

        // 둘 다 이긴 경우 불가능
        if (xWin && oWin) return false;

        // X가 이긴 경우, X가 O보다 1개 많아야 함
        if (xWin) return cntX == cntO + 1;

        // O가 이긴 경우, X와 O 개수가 같아야 함
        if (oWin) return cntX == cntO;

        // 아무도 안 이긴 경우
        return cntX + cntO == 9;
    }


    static boolean win(char[] board, char ch) {
        int[][] lines = {
                {0,1,2}, {3,4,5}, {6,7,8}, // 가로
                {0,3,6}, {1,4,7}, {2,5,8}, // 세로
                {0,4,8}, {2,4,6}           // 대각선
        };

        for (int[] line : lines) {
            if (board[line[0]] == ch && board[line[1]] == ch && board[line[2]] == ch) {
                return true;
            }
        }
        return false;
    }
}