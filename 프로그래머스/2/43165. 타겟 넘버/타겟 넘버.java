import java.util.*;
class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        back(numbers, target, 0, 0);
        return answer;
    }
    
    public void back(int[] numbers, int target, int sum, int idx) {
        if(idx >= numbers.length) {
            if(sum == target) answer++;
            return;
        }
        
        back(numbers, target, sum + numbers[idx], idx+1);
        back(numbers, target, sum - numbers[idx], idx+1);
    }
}