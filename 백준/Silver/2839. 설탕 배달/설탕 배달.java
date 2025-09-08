import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int N, answer;
		
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	int cnt = 0;
    	
    	while(N > 0) {
    		if(N%5 == 0) {
    			answer = N/5;
    			break;
    		}
    		if(N > 0 && N < 3) {
    			answer = -1;
    			break;
    		}
    		N -= 3;
    		cnt++;
    	}
    	
    	if(answer == -1) {
    		System.out.println(-1);
    	} else {
    		System.out.println(answer + cnt);
    	}
    	
    }    
}

