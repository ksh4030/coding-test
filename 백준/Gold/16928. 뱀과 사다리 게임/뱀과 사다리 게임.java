import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		
		M = Integer.parseInt(st.nextToken());
		arr = new int[101];
		
		for(int i=1; i<=100; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<N+M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a] = b;
		}
		
		bfs();
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		int[] check = new int[101];
		q.add(1);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(cur > 100) {
				break;
			}
			
			for(int i=1; i<=6; i++) {
				if(cur + i > 100) {
					continue;
				}
				
				if(check[arr[cur + i]] == 0) {
					q.add(arr[cur + i]);
					check[arr[cur+i]] = check[cur] + 1;
				}
				if(arr[cur+i] == 100) {
					System.out.println(check[100]);
					return;
				}
			}
		}
	}
}