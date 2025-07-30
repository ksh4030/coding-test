import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            int tmp = n%3;
            n /= 3;            
            if(tmp == 0) {
                list.add(4);
                n--;
            } else if(tmp == 1) {
                list.add(1);
            } else {
                list.add(2);
            }
        }
        
        for(int i=list.size()-1; i>=0; i--) {
            answer += String.valueOf(list.get(i));
        }
        
        return answer;
    }
}