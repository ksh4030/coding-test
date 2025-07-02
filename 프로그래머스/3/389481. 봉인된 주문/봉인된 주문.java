import java.util.*;
class Solution {
    public String solution(long n, String[] bans) {
        long[] arr = new long[bans.length];
        
        for(int i=0; i<bans.length; i++) arr[i] = alphabetToNum(bans[i]);
        
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) if(arr[i] <= n) n++;
        
        return numToAlphabet(n);
    }
    
    public String numToAlphabet(long num) {
        StringBuilder sb = new StringBuilder();
        
        while(num > 0) {
            num--; //26진수 0이 a인데 해당 문제는 1이 a임
            long bucket = num % 26;
            sb.append((char) ('a' + bucket));
            num /= 26;
        }
        
        return sb.reverse().toString();
    }
    
    public long alphabetToNum(String s) {
        long res = 0;
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            long bucket = ch - 'a' + 1;
            res = res*26 + bucket;
        }
        
        return res;
    }
}