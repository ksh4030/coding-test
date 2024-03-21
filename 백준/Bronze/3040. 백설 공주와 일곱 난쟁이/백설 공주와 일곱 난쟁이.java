import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] arr, sel;
	static boolean c;
		
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	arr = new int[9];
    	sel = new int[7];
    	c = false;
    	
    	for(int i=0; i<9; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}
    	
    	getC(0, 0);
    	for(int i=0; i<7; i++) {
    		System.out.println(sel[i]);
    	}
    	
    }
    
    public static void getC(int idx, int k) {
    	if(k == sel.length) {
    		if(Arrays.stream(sel).sum() == 100) {
    			c = true;
    		}
    		return;
    	}
    	
    	for(int i=idx; i<arr.length; i++) {
    		sel[k] = arr[i];
    		getC(i+1, k+1);
    		if(c) break;
    	}
    	
    }
 }

