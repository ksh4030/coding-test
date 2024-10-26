import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        int open = 0;
        int close = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add('(');
                open++;
            } else {
                if(stack.isEmpty()) return false;
                stack.pop();
                close++;
            }
            if(close > open) return false;
        }

        return close == open;
    }
}