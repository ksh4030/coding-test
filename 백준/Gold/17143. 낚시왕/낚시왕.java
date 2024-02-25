import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int R, C, M, answer;
	static boolean[][] visit;
	static List<Shark> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[R+1][C+1];
		list = new ArrayList<>();

		int r, c, s, d, z;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());			
			z = Integer.parseInt(st.nextToken());			
			list.add(new Shark(r, c, s, d, z));
		}
		int current = 0;
		
		for(int fishing=0; fishing<=C; fishing++) {
			current++;
			fishing(current);
			Collections.sort(list);
			move();
		}
		
		System.out.println(answer);
		
	}
	
	static void move() {
		//d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미
		visit = new boolean[R+1][C+1];
		for(int i=0; i<list.size(); i++) {
			Shark s = list.get(i);
			for(int j=0; j<s.s; j++) {
				if(s.r==1 && s.d==1) {
					s.d = 2;
				}
				if(s.r==R && s.d==2) {
					s.d = 1;
				}
				if(s.c==1 && s.d==4) {
					s.d = 3;
				}
				if(s.c==C && s.d==3) {
					s.d = 4;
				}
				switch (s.d) {
				case 1:
					s.r--;
					break;
				case 2:
					s.r++;
					break;
				case 3:
					s.c++;
					break;
				case 4:
					s.c--;
					break;
				default:
					break;
				}
			}
			if(visit[s.r][s.c]) {
				list.remove(i);
				i--;
			} else {
				visit[s.r][s.c] = true;
			}
		}
	}
	
	static void fishing(int current) {
		int near = Integer.MAX_VALUE;
		int idx = -1;
		for(int i=0; i<list.size(); i++) {
			if(current == list.get(i).c) {
				if(near > list.get(i).r) {
					near = list.get(i).r;
					idx = i;
				}
			}
		}
		if(near < Integer.MAX_VALUE) {
			answer += list.get(idx).z;
			list.remove(idx);			
		}		
	}
	
	static class Shark implements Comparable<Shark>{
		int r, c, s, d, z;
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public int compareTo(Shark o) {
			return Integer.compare(o.z, this.z);
		}
	}
}
