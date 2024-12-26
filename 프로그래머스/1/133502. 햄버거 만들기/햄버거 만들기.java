import java.util.*;
class Solution {
    static Stack<Integer> stack = new Stack<>();
    public int solution(int[] ingredient) {
        int answer = 0;
        
        for(int i=0; i<ingredient.length; i++) {
            if(stack.size() >= 4 && stack.peek() == 1) {
                if(isPossible()) answer++;
            }
            stack.add(ingredient[i]);
        }
        
        if(stack.size() >= 4 && stack.peek() == 1 && isPossible()) answer++;
        return answer;
    }
    
    public boolean isPossible() {
        Stack<Integer> bucket = new Stack<>();
        
        bucket.add(stack.pop());
        if(!stack.isEmpty() && stack.peek() == 3) bucket.add(stack.pop());
        if(!stack.isEmpty() && stack.peek() == 2) bucket.add(stack.pop());
        if(!stack.isEmpty() && stack.peek() == 1) bucket.add(stack.pop());
        
        if(bucket.size() == 4) {
            return true;
        } else {
            while(!bucket.isEmpty()) {
                stack.add(bucket.pop());
            }
        }
        return false;
    }
}