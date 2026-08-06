import java.util.*;
class Solution {
    static int[] arr1;
    static int[] arr2;
    public long solution(int[] sequence) {
        arr1 = new int[sequence.length];
        arr2 = new int[sequence.length];
        
        init(sequence);
        
        long answer = Math.max(arr1[0], arr2[0]);
        long cur = arr1[0];
        
        for(int i=1; i<arr1.length; i++) {
            cur = Math.max(cur + arr1[i], arr1[i]);
            answer = Math.max(cur, answer);
        }
        
        cur = arr2[0];
        for(int i=1; i<arr2.length; i++) {
            cur = Math.max(cur + arr2[i], arr2[i]);
            answer = Math.max(cur, answer);
        }
        
        return answer;
    }
    
    public void init(int[] sequence) {
        for(int i=0; i<arr1.length; i++) {
            if(i%2 == 0) {
                arr1[i] = sequence[i]*1;
                arr2[i] = sequence[i]*-1;
            } else {
                arr1[i] = sequence[i] * -1;
                arr2[i] = sequence[i] * 1;
            }
            
        }
    }
}