import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String[] arr = s.split("");
        Stack<String> stack = new Stack<>();
        
        for(String a : arr) {
            if(a.equals("(")) {
                stack.push("(");
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}