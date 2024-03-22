import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int a, b;
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			if(i == 0) {
				arr[i] = sc.nextInt();
				continue;
			} 
			arr[i] = arr[i - 1] + sc.nextInt();
		}
		
		
		for(int i = 0; i<M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			if(a == 1) {
				System.out.println(arr[b-1]);
			} else {
				System.out.println(arr[b-1] - arr[a - 2]);
			}
		}
		

	}

}