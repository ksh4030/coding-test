import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] target = {scores[0][0], scores[0][1]};
        
        Arrays.sort(scores, (o1, o2) -> {
            return o1[0]==o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });
        
        int num = scores[0][1];
        for(int i=1; i<scores.length; i++) {
            if(num > scores[i][1]) {
                if(scores[i][0]==target[0] && scores[i][1]==target[1]) return -1;
                scores[i][0] = scores[i][1] = -1;
            } else {
                num = scores[i][1];
            }
        }
        
        Arrays.sort(scores, (o1, o2) -> {
           return (o2[0]+o2[1]) - (o1[0]+o1[1]);
        });   
        
        for(int i=0; i<scores.length; i++) {
            if(scores[i][0] + scores[i][1] > target[0] + target[1]) answer++;
            else break;
        }
        
        return answer;
    }
}