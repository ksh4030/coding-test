import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M, answer;
	static int[][] arr, bucket;
	static List<Node> list = new ArrayList<>();
	static List<Node> virus = new ArrayList<>();
	static Queue<Node> virusQ;
	static Node[] sel = new Node[3];	
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
		
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");   
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N][M];
    	
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0; j<M; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    			if(arr[i][j] == 0) {
    				list.add(new Node(i,j));
    			}
    			if(arr[i][j] == 2) {
    				virus.add(new Node(i, j));
    			}
    		}
    	}
    	
    	getComb(0, 0);
    	
    	System.out.println(answer);
    	
    }
    
    static public void getComb(int idx, int k) {
    	if(k == sel.length) {
    		bucket = new int[N][M];
    		int cnt = 0;
        	for(int i=0; i<N; i++) {
        		bucket[i] = arr[i].clone();
        	}
        	
        	for(int i=0; i<sel.length; i++) {
        		bucket[sel[i].r][sel[i].c] = 1;
        	}
        	
        	virusQ = new LinkedList<>();
        	for(int i=0; i<virus.size(); i++) {
        		virusQ.add(virus.get(i));
        	}
    		recur();
    		    		
    		for(int i=0; i<bucket.length; i++) {
    			for(int j=0; j<bucket[i].length; j++) {
    				if(bucket[i][j] == 0) {
    					cnt++;
    				}
    			}
    		}
    		answer = Math.max(answer, cnt);
    		return;
    	}
    	
    	for(int i=idx; i<list.size(); i++) {
    		sel[k] = list.get(i);
    		getComb(i+1, k+1);
    	}
    	
    }
    
    static public void recur() {
    	while(virusQ.size() > 0) {
    		Node current = virusQ.poll();
    		
    		for(int i=0; i<4; i++) {
    			int nr = current.r + dr[i];
    			int nc = current.c + dc[i];
    			
    			if(nr<0 || nc<0 || nr>=N || nc>=M || bucket[nr][nc]!=0) {
    				continue;
    			}
    			bucket[nr][nc] = 2;
    			virusQ.add(new Node(nr, nc));
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

