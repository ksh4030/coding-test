import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static int answer;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	int R = Integer.parseInt(st.nextToken());
    	
    	int startN = 0;
    	int endN = N;
    	int startM = 0;
    	int endM = M;
    	
    	arr = new int[N][M];
    	
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<M; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int len = Math.min(N, M) / 2;
    	
    	for (int i = 0; i < len; i++) {
			Deque<Integer> dq = new ArrayDeque<>();
			
			loop:
			for(int j=startN+i; j<endN - i; j++) {
				for(int k=startM+i; k<endM-i; k++) {
					dq.add(arr[j][k]);
					arr[j][k] = 0;
					int nr = j;
					int nc = k;
					for(int l=0; l<4; l++) {
						nr += dr[l];
						nc += dc[l];
						while(nc>=startN+i && nr>=startM+i && nc<endN-i && nr<endM-i) {
							if(arr[nc][nr] == 0) {
								break loop;
							}
							dq.add(arr[nc][nr]);
							arr[nc][nr] = 0;
							nr += dr[l];
							nc += dc[l];
						}
						nr -= dr[l];
						nc -= dc[l];
					}
					
				}
			}
			
			for(int j=0; j<R; j++) {
				dq.addFirst(dq.removeLast());
			}
			loop:
			for(int j=startN+i; j<endN - i; j++) {
				for(int k=startM+i; k<endM-i; k++) {
					arr[j][k] = dq.poll();
					int nr = j;
					int nc = k;
					for(int l=0; l<4; l++) {
						nr += dr[l];
						nc += dc[l];
						while(nc>=startN+i && nr>=startM+i && nc<endN-i && nr<endM-i) {
							if(dq.size() <=0) {
								break loop;
							}
							arr[nc][nr] = dq.poll();
							nr += dr[l];
							nc += dc[l];
						}
						nr -= dr[l];
						nc -= dc[l];
					}
					
				}
			}
			
		}
    	
    	for(int i=0; i<arr.length; i++) {
    		for(int j=0; j<arr[i].length; j++) {
    			System.out.print(arr[i][j] + " ");
    		}
    		System.out.println();
    	}
	}
}



