import java.util.*;
class Solution {
    static final long NUMBER = 1234567;
    public long solution(int n) {
        long answer = 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        long num1 = 1;
        long num2 = 2;
        
        for(int i=3; i<=n; i++) {
            long tmp = num2;
            num2 = (num1+num2)%NUMBER;
            num1 = tmp;            
        }
        
        return num2%NUMBER;
    }
}