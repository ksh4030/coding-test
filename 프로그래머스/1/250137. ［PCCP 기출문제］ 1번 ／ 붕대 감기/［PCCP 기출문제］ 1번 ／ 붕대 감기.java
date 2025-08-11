import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        
        int cnt = 0;
        int idx = 0;
                
        for(int i=1; i<=attacks[attacks.length-1][0]; i++) {
            if(attacks[idx][0] == i) {
                answer -= attacks[idx][1];
                if(answer <= 0) return -1;
                idx++;
                cnt = 0;
            } else {
                answer += bandage[1];
                cnt++;
                if(cnt == bandage[0]) {
                    answer += bandage[2];
                    cnt = 0;
                }
                if(answer > health) answer = health;
            }
        }
        
        return answer <= 0 ? -1 : answer;
    }
}