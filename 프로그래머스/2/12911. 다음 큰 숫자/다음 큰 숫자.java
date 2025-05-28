import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int target = n+1;
        
        while(true) {
            if(isPossible(n, target)) {
                answer = target;
                break;
            }
            target++;
        }
        
        return answer;
    }
    
    public boolean isPossible(int n, int target) {
        String a = Integer.toString(n, 2);
        String b = Integer.toString(target, 2);
        
        int x = 0;
        int y = 0;
        
        for(int i=0; i<a.length(); i++) if(a.charAt(i) == '1') x++;
        for(int i=0; i<b.length(); i++) if(b.charAt(i) == '1') y++;
        
        return x == y;
    }
}