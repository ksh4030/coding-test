import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int N, M, answer;
	static List<Integer>[] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = 0;
		
		arr = new List[N];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i=0; i<N; i++) {
			find(i, 1);
			if(answer == 1) {
				break;
			}
		}
		System.out.println(answer);
	}
	
	public static void find(int current, int cnt) {
		if(cnt==5) {
			answer = 1;
			return;
		}
		
		visit[current] = true;
		for(int i=0; i<arr[current].size(); i++) {
			if(!visit[arr[current].get(i)]) {
				find(arr[current].get(i), cnt+1);
			}
		}
        
		visit[current] = false;
	}
}
