import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int[] a = new int[sequence.length];
        int[] b = new int[sequence.length];
        
        for(int i=0; i<sequence.length; i++) {
            if(i%2 == 0) {
                a[i] = sequence[i];
                b[i] = sequence[i] * -1;
            } else {
                a[i] = sequence[i] * -1;
                b[i] = sequence[i];
            }
        }        
        answer = Math.max(kadane(a), kadane(b));        
        return answer;
    }
    
    public static long kadane(int[] arr) {
        long max = 0;
        long cur = 0;
        
        for(int i=0; i<arr.length; i++) {
            cur = Math.max(arr[i], cur+arr[i]);
            max = Math.max(cur, max);
        }
        
        return max;
    }
}