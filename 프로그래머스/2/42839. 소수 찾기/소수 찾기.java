import java.util.*;
class Solution {
    static int answer = 0;
    static HashMap<Integer, Boolean> map = new HashMap<>();
    public int solution(String numbers) {
        String[] arr = numbers.split(""); 
        
        for(int i=1; i<=numbers.length(); i++) {            
            per(arr, new String[i], 0, new boolean[arr.length]);
        }
        
        return answer;
    }
    
    public void per(String[] arr, String[] sel, int idx, boolean[] v) {
        if(idx == sel.length) {
            String s = "";
            for(String a : sel) s+=a;
            int n = Integer.parseInt(s);
            
            if(map.get(n) == null) {
                if(isPrime(n)) answer++;
                map.put(n, true);
            }            
            return;
        }
        
        for(int i=0; i<arr.length; i++) {
            if(!v[i]) {
                v[i] = true;
                sel[idx] = arr[i];
                per(arr, sel, idx+1, v);
                v[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {     
        if(n < 2) return false;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
}