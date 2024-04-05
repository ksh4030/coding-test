import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int N = Integer.parseInt(br.readLine());
		int[] Day = new int[N];
		int[] Money = new int[N];
		int[] cal = new int[N+1];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			Day[i] = Integer.parseInt(st.nextToken());
			Money[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int curMoney = cal[i] + Money[i];
			if(i+Day[i] <= N) {
				for(int j=i+Day[i]; j<=N; j++) {
					cal[j] = Math.max(cal[j], curMoney);
				}
			}
		}
		
		System.out.println(cal[N]);
	}
}

