class Solution {
    public int solution(String s) {
        if(s.length() == 1) {
            return 1;
        }
        int answer = Integer.MAX_VALUE;        
        
        for(int i=1; i<=s.length()/2; i++) {
            String cur = s.substring(0, i);
            int cnt = 1;
            String ans = "";
            
            for(int j=i; j<=s.length(); j+=i) {
                String next = "";
                
                if(i+j > s.length()) {
                    next = s.substring(j, s.length());
                } else {
                    next = s.substring(j, i+j);
                }
                
                if(cur.equals(next)) {
                    cnt++;
                } else {
                    if(cnt > 1) ans += Integer.toString(cnt);
                    ans += cur;
                    cur = next;
                    cnt = 1;
                }
            }
            ans += cur;
            answer = Math.min(answer, ans.length());
        }
        
        return answer;
    }
}