import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int x = scores[0][0];
        int y = scores[0][1];
        
        Arrays.sort(scores, (o1,o2) -> {
            return o1[0] == o2[0] ? o1[1]-o2[1] : o2[0] - o1[0];
        });
        
        int standard = scores[0][1];
        for(int i=1; i<scores.length; i++) {
            if(scores[i][1] < standard) {
                if(scores[i][0]==x && scores[i][1]==y) return -1;
                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                standard = scores[i][1];
            }
        }
        
        Arrays.sort(scores, (o1, o2) -> {
            return (o2[0]+o2[1]) - (o1[0]+o1[1]);
        });
        
        // System.out.println(Arrays.deepToString(scores));
        // System.out.println(x+y);
        
        for(int i=0; i<scores.length; i++) {
            if(scores[i][0] + scores[i][1] > x+y) {
                answer++;
            } else {
                break;
            } 
        }
        
        return answer+1;
    }
}