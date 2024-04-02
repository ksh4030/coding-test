

import java.util.*;

public class Main {
	
	static int[] arr;
	static int[] answer;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[N];
		answer = new int[M];
		check = new boolean[N];
		
		for(int i=1; i<=N; i++) {
			arr[i-1] = i;
		}
		
		recursive(0);
		
	}

	private static void recursive(int idx) {
		
		if(idx == answer.length) {
			for(int i=0; i<answer.length; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(!check[i]) {
				check[i] = true;
				answer[idx] = arr[i];
				recursive(idx + 1);
				check[i] = false;
			}
		}
		
	}
	
	

}
