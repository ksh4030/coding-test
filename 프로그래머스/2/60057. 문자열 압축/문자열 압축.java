import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;        
        
        for(int i=1; i<=s.length(); i++) {
            String cur = s.substring(0, i);
            int cnt = 1;
            String ans = "";
            
            for(int j=i; j<=s.length(); j+=i) {
                String bucket = "";
                
                if(j+i >= s.length()) {
                    bucket = s.substring(j, s.length());
                } else {
                    bucket = s.substring(j, j+i);
                }
                
                if(cur.equals(bucket)) {
                    cnt++;
                } else {
                    if(cnt > 1) {
                        ans += String.valueOf(cnt);
                    }
                    ans += cur;
                    cur = bucket;
                    cnt = 1;
                }
            }
            ans += cur;
            answer = Math.min(answer, ans.length());
        }
        
        return answer;
    }
}