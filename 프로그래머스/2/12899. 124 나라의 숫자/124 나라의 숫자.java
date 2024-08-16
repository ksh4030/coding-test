import java.util.*;
class Solution {
    public String solution(int n) {        
        List<String> list = new ArrayList<>();
        while(n >= 1) {            
            switch(n%3) {
                case 0 :
                    list.add("4");
                    n = n/3 - 1;
                    break;
                case 1:
                    list.add("1");
                    n /= 3;
                    break;
                case 2:
                    list.add("2");
                    n/=3;
                    break;
            }
        }
        
        String answer = "";
        Collections.reverse(list);
        for(String s : list) answer += s;
        return answer;
    }
}