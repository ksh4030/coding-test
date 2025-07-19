import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            int tmp = storey % 10;
            int next = (storey / 10) % 10;
            
            if(tmp > 5) {
                answer += 10-tmp;
                storey += 10;
            } else if (tmp < 5){
                answer += tmp;
            } else {
                if(next >= 5) {
                    answer += 10-tmp;
                    storey += 10;
                } else {
                    answer += tmp;
                }
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}