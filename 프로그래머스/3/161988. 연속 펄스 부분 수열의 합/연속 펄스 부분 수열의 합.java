import java.util.*;
class Solution {
    static int[] a, b;
    public long solution(int[] sequence) {
        long answer = 0;
        init(sequence);
        answer = sw(a);        
        return Math.max(answer, sw(b));
    }
    
    public long sw(int[] arr) {
        long sum = Integer.MIN_VALUE;
        long max = 0;
        
        for(int i=0; i<arr.length; i++) {
            sum = Math.max(sum+arr[i], arr[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
    
    public void init(int[] sequence) {
        a = new int[sequence.length];
        b = new int[sequence.length];
        
        for(int i=0; i<sequence.length; i++) {
            if(i%2 == 0) {
                a[i] = sequence[i];
                b[i] = sequence[i] * -1;
            } else {
                a[i] = sequence[i] * -1;
                b[i] = sequence[i];
            }
        }
    }
}