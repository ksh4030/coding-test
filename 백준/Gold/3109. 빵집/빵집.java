import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int R, C, answer;
	static char[][] arr;
	static boolean[][] visit;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		visit = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for(int j=0; j<C; j++) {
				arr[i][j] = s.charAt(j); 
			}
		}
		
		for(int i=0; i<R; i++) {
			if(steal(i, 0)) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	public static boolean steal(int r, int c) {
		arr[r][c] = ' ';
		if(c == C-1) {
			return true;
		}
		
		if(r-1>=0 && arr[r-1][c+1]=='.') {
			if(steal(r-1, c+1)) {
				return true;
			}
		}
		
		if(arr[r][c+1] =='.') {
			if(steal(r, c+1)) {
				return true;
			}
		}
		
		if(r+1<R && arr[r+1][c+1] == '.') {
			if(steal(r+1, c+1)) {
				return true;
			}
		}
		
		return false;
	}
	
}
