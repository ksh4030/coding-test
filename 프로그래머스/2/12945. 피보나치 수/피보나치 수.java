import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;        
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        
        for(int i=2; i<n; i++) {
            int x = arr[i-1] + arr[i-2];
            arr[i] = x%1234567;
        }
        
        return arr[n-1];
    }
}