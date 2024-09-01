import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 2;
        
        if(a.length < 3) return a.length;
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        
        int min = a[0];
        for(int i=1; i<left.length-1; i++) {
            if(min > a[i]) min = a[i];            
            left[i] = min;            
        }
        min = a[a.length-1];
        for(int i=right.length-2; i>0; i--) {
            if(min > a[i]) min = a[i];
            right[i] = min;
        }        
        for(int i=1; i<a.length-1; i++) {
            if(a[i] > left[i] && a[i] > right[i]) continue;
            answer++;
        }
        
        return answer;
    }
}