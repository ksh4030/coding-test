import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 2; //양 끝은 무조건 남을 수 있음
        int[] right = new int[a.length], left = new int[a.length];
        left[0] = a[0];
        right[a.length-1] = a[a.length-1];
        
        for(int i=1; i<a.length; i++) {
            left[i] = Math.min(left[i-1], a[i]);
        }
        
        for(int i=a.length-2; i>=0; i--) {
            right[i] = Math.min(right[i+1], a[i]);
        }
        
        for(int i=1; i<a.length-1; i++) {
            if(a[i] <= left[i-1] || a[i] <= right[i+1]) answer++;
        }
        
        return answer;
    }
}