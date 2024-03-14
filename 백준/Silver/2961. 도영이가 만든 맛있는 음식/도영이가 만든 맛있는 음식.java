
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static boolean[] sel;
	static int[] num;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][2];
		sel = new boolean[N];
		num = new int[N];
		answer = Integer.MAX_VALUE;		
		
		for(int i=0; i<N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for(int j=0; j<2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			num[i] = i+1;
		}
		
		recur(0);
		
		System.out.println(answer);

	}
	
	public static void recur(int idx) {
		if(idx == num.length) {
			int sumS = 1;
			int sumB = 0;
			for(int i=0; i<sel.length; i++) {
				if(sel[i]) {					
					sumS *= arr[num[i]-1][0];
					sumB += arr[num[i]-1][1];
				}
			}
			if(sumS != 1 && sumB != 0)
				answer = Math.min(answer, Math.abs(sumS - sumB));			
			return;
		}
		
		sel[idx] = true;
		recur(idx + 1);
		sel[idx] = false;
		recur(idx + 1);
	}
		
	
}
