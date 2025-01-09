import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        boolean flag = true;
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals(" ")) {
                flag = true;
                answer += arr[i];
                continue;
            }
            
            if(flag) {
                answer += arr[i].toUpperCase();
                flag = false;
            } else {
                answer += arr[i].toLowerCase();
            }
        }
        return answer;
    }
}