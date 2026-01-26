import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        answer += Integer.toString(arr[0]) + " " + Integer.toString(arr[arr.length-1]);
        
        return answer;
    }
}