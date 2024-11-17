import java.util.*;
class Solution {
    static final int MOD = 1234567;
    public long solution(int n) {
        long answer = 0;
        long num1 = 1;
        long num2 = 2;
        
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        for(int i=3; i<=n; i++) {
            answer = (num1 + num2) % MOD;            
            num1 = num2;
            num2 = answer;
        }
        
        return answer;
    }
}