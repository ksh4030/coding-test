import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int n = stack.pop();
                answer[n] = i - n;
            }            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int n = stack.pop();
            answer[n] = prices.length - 1 - n;
        }
        
        return answer;
    }
}