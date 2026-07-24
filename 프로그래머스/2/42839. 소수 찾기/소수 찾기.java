import java.util.*;
class Solution {
    static Map<Integer, Boolean> map = new HashMap<>();
    static boolean[] v;
    static int answer = 0;
    
    public int solution(String numbers) {        
        String[] arr = numbers.split("");
        v = new boolean[arr.length];
        
        for(int i=1; i<=arr.length; i++) {
            per(arr, "", 0, i);
        }
        
        return answer;
    }
    
    public void per(String[] arr, String ans, int depth, int r) {
        if(depth == r) {
            int num = Integer.valueOf(ans);
            if(num > 0 && !map.getOrDefault(num, false)) {
                map.put(num, true);
                if(isPrime(num)) answer++;
            }
            return;
        }
        
        for(int i=0; i<arr.length; i++) {
            if(!v[i]) {
                v[i] = true;                
                per(arr, ans + arr[i], depth+1, r);
                v[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if(num < 2) return false;
        
        for(int i=2; i<=num/i; i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}