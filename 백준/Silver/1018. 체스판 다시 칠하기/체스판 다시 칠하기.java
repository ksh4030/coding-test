import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[][] board = new char[N][M];
        
        // 보드 입력 받기
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        
        int minPaint = Integer.MAX_VALUE;
        
        // 8x8 체스판을 자를 수 있는 모든 위치에서 체크
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minPaint = Math.min(minPaint, getMinRepaints(board, i, j));
            }
        }
        
        System.out.println(minPaint);
    }
    
    // 8x8 영역에서 다시 칠해야 할 최소 칸 수를 계산하는 함수
    public static int getMinRepaints(char[][] board, int startRow, int startCol) {
        int count1 = 0; // 첫 번째 칸이 'W'로 시작하는 경우
        int count2 = 0; // 첫 번째 칸이 'B'로 시작하는 경우
        
        char[] pattern = {'W', 'B'}; // 두 색의 패턴
        
        // 8x8 크기 탐색
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expectedChar1 = pattern[(i + j) % 2]; // 첫 칸이 'W'로 시작할 때 예상되는 값
                char expectedChar2 = pattern[(i + j + 1) % 2]; // 첫 칸이 'B'로 시작할 때 예상되는 값
                
                if (board[startRow + i][startCol + j] != expectedChar1) {
                    count1++;
                }
                if (board[startRow + i][startCol + j] != expectedChar2) {
                    count2++;
                }
            }
        }
        
        return Math.min(count1, count2); // 두 경우 중 더 적은 값을 반환
    }
}
