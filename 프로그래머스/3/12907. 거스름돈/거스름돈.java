import java.util.*;
class Solution {
    static final int MOD = 1_000_000_007;
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] arr = new int[n+1];
        arr[0]= 1;
        
        for(int coin : money) {
            for(int i=coin; i<=n; i++) {
                arr[i] = (arr[i] + arr[i-coin]) % MOD;
            }
        }
        
        return arr[n];
    }
}