import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++) {
            for(int j=s.length()-1; j>=i; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(i == j) answer = Math.max(1, answer);
                    if(isPossible(s, i, j)) answer = Math.max(answer, j - i + 1);
                }
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }
}