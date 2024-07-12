import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a = arrayA[0];
        int b = arrayB[0];
        
        for(int i=1; i<arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
            b = gcd(b, arrayB[i]);
        }
        
        boolean aa = true;
        boolean bb = true;
        
        for(int i=0; i<arrayA.length; i++) {
            if(arrayA[i] % b == 0) aa = false;
            if(arrayB[i] % a == 0) bb = false;
        }
        
        if(aa && bb) {
            answer = Math.max(a, b);
        } else if(aa) {
            answer = b;
        } else if(bb) {
            answer = a;
        }
        
        return answer;
    }
    
    public static int gcd(int num1, int num2) {
        if(num2 == 0) return num1;
        return gcd(num2, num1 % num2);
    }
}