import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static String arr[][];
	static Node cave, location;
	static List<Node> water, rock;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new String[R][C];
		water = new ArrayList<>();
		rock = new ArrayList<>();
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = Character.toString(s.charAt(j));
				if(arr[i][j].equals("D")) {
					cave = new Node(i, j, 0);
				} else if(arr[i][j].equals("S")) {
					location = new Node(i, j, 0);
				} else if(arr[i][j].equals("X")) {
					rock.add(new Node(i,j,0));
				} else if(arr[i][j].equals("*")) {
					water.add(new Node(i,j,0));
				}
			}
		}
		
		bfs();
		System.out.println("KAKTUS");		
	}
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(location.r, location.c, location.time));
		int curTime = -1;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(curTime < cur.time) {
				curTime = cur.time;
				moveWater();
			}		
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				try {
					if(arr[nr][nc].equals("D")) {
						System.out.println(cur.time + 1);
						System.exit(0);
					} else if (arr[nr][nc].equals(".")) {
						arr[nr][nc] = "S";
						q.add(new Node(nr, nc, cur.time + 1));
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
	}
	
	private static void moveWater() {
		int size = water.size();
		
		for(int i=0; i<size; i++) {
			Node cur = water.get(0);
			for(int j=0; j<4; j++) {
				int nr = cur.r + dr[j];
				int nc = cur.c + dc[j];
				
				try {
					if(arr[nr][nc].equals(".")) {
						arr[nr][nc] = "*";
						water.add(new Node(nr, nc, 0));						
					}
				} catch (Exception e) {
					continue;
				}
			}
			water.remove(0);
		}
	}

	static class Node {
		int r,c,time;
		public Node(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
			
	}
}