import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int N, K, answer;
	static Queue<Node> q = new LinkedList<>();
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		visit = new boolean[100001];
		visit[N] = true;
		recur(new Node(N, 0));
		
		System.out.println(answer);
	}
	
	public static void recur(Node node) {
		q.add(node);
		
		while(!q.isEmpty()) {
			Node current = q.poll();			
			if(current.n == K) {
				answer = current.cnt;
				return;
			}
			int tmp = 0;
			for(int i=0; i<3; i++) {
				if(i == 0) {
					tmp = current.n + 1;
				} else if (i==1) {
					tmp = current.n * 2;
				} else if (i==2) {
					tmp = current.n - 1;
				}
				if(tmp>=0 && tmp<=100000 && !visit[tmp]) {
					visit[tmp] = true;
					q.add(new Node(tmp, current.cnt+1));
				}
			}
			
		}
	}
	
	static class Node{
		int n, cnt;

		public Node(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}		
	}
 }

