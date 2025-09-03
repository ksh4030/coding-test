import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M, answer;
	static String[][] arr;
	static Queue<Node> q = new LinkedList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][] v;
		
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	arr = new String[N][M];
    	v = new boolean[N][M];
    	answer = Integer.MAX_VALUE;
    	
    	for(int i=0; i<N; i++) {
    		String s = br.readLine();
    		arr[i] = (s.split(""));
    	}
    	
    	
    	v[0][0] = true;
    	maze(new Node(0, 0, 1));
    	
    	System.out.println(answer);
    	
    	
    }
    
    public static void maze(Node node) {
    	q.add(node);
    	
    	
    	while(q.size()>0) {
    		Node current = q.poll();
    		if(current.r == N-1 && current.c == M-1) {
    			answer = Math.min(answer, current.cnt);
    		}
    		    		
    		for(int i=0; i<4; i++) {
    			int nr = current.r + dr[i];
    			int nc = current.c + dc[i];
    			
    			if(nr<0 || nc<0 || nr>=N || nc>=M || arr[nr][nc].equals("0") || v[nr][nc]) {
    				continue;
    			}
    			v[nr][nc] = true;
    			q.add(new Node(nr, nc, current.cnt+1));
    		}
    	}
    	
    }
    
    static class Node {
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

