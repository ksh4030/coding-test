
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Queue<Node> tomato = new LinkedList<>();
	static int answer;
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    	M = Integer.parseInt(st.nextToken());
    	N = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N][M];
    	answer = 0;
    	
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<M; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    			if(arr[i][j] == 1) {
    				arr[i][j] = 2;
    				tomato.add(new Node(i,j,0));
    			}
    		}
    	}
    	bfs();
    	loop:
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			if(arr[i][j] == 0) {
    				answer = -1;
    				break loop;
    			}
    		}
    	}
    	System.out.println(answer);
    	
    }
    
    public static void bfs() {
    	
    	while(tomato.size() > 0) {
    		Node current = tomato.poll();
    		
    		for(int i=0; i<4; i++) {
    			int nr = current.r + dr[i];
    			int nc = current.c + dc[i];
    			
    			if(nr < 0 || nc < 0 || nr >= N || nc >= M || arr[nr][nc] != 0) {
    				continue;
    			}
    			if(arr[nr][nc] == 0) {
    				arr[nr][nc] = 2;
    				tomato.add(new Node(nr, nc, current.cnt+1));
    				answer = Math.max(answer, current.cnt + 1);
    			}
    		}
    		
    	}
    	
    }
    
    static class Node{
    	int r;
    	int c;
    	int cnt;
		public Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
    }
}



