import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] dr = {-1, 0, 1, 0, -1, -1 , 1, 1};
	static int[] dc = {0, 1, 0, -1, -1, 1, 1, -1};
	static int answer;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	while(true) {
    		int num = 2;
    		int cnt = 0;
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    		int M = Integer.parseInt(st.nextToken());
    		int N = Integer.parseInt(st.nextToken());
    	
    		if(M == 0 && N == 0) {
    			break;
    		}
    	
    		arr = new int[N][M];
    	
    		for(int i=0; i<N; i++) {
    			st = new StringTokenizer(br.readLine(), " ");
    			for(int j=0; j<M; j++) {
    				arr[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    	
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<M; j++) {
    				if(arr[i][j] == 1) {
    					arr[i][j] = num;
    					findIsland(new Node(i, j), num);
    					cnt++;
    				}
    			}
    		}
    		System.out.println(cnt);
    	}
    	    	
    }
	private static void findIsland(Node node, int num) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		
		while(q.size() > 0) {
			Node current = q.poll();
			
			for(int i=0; i<8; i++) {
				int nr = current.r + dr[i];
				int nc = current.c + dc[i];				
				try {
					if(arr[nr][nc] == 1) {
						arr[nr][nc] = num;		
						q.add(new Node(nr, nc));
					}					
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
			
		}
	}
	
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}



