import java.util.*;
class Solution {
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        bt(0, 0, numbers, target, 0);
        
        return cnt;
    }
    
    public static void bt(int depth, int idx, int[] numbers, int target, int sum) {
        if(depth == numbers.length) {
            if(sum == target) cnt++;
            return;
        }
        
        bt(depth+1, idx+1, numbers, target, sum + numbers[idx]);
        bt(depth+1, idx+1, numbers, target, sum - numbers[idx]);
    }
}