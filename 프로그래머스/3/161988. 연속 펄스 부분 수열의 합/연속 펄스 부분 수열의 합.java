import java.util.*;
class Solution {
    static long max;
    public long solution(int[] sequence) {
        long answer = 0;
        max = 0;
        int[] a = sequence.clone();
        int[] b = sequence.clone();
        
        for(int i=0; i<sequence.length; i++) {
            if(i%2 == 0) {
                a[i] *= -1;
            } else {
                b[i] *= -1;
            }
        }
        kadane(a);
        kadane(b);
        return max;
    }
    
    public static void kadane(int[] arr) {
        long cur = 0;
        for(int i=0; i<arr.length; i++) {
            cur = Math.max(arr[i], cur+arr[i]);
            max = Math.max(cur, max);
        }
    }
}
