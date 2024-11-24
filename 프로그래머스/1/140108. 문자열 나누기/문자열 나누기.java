class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int cnt = 1;
        int diff = 0;
        char cur = s.charAt(0);
        
        for(int i=1; i<s.length(); i++) {
            if(cnt == diff) {
                answer++;
                cnt = 1;
                diff = 0;
                cur = s.charAt(i);
                continue;
            }
            if(cur == s.charAt(i)) {
                cnt++;
            } else {
                diff++;
            }
        }
        
        return answer+1;
    }
}