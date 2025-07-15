import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        Arrays.sort(arr);
        for(int i=1; i<arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        while(b!=0) {
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        return a;
    }
    
    public int lcm(int a, int b) {
        // if(a<b) {
        //     int tmp = a;
        //     a = b;
        //     b = tmp;
        // }
        return a*b / gcd(a,b);
    }
}