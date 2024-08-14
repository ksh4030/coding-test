import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length-1};
        int head = 0;
        int tail = 1;
        int sum = sequence[0];        
        
        while(head < tail) {
            if(sum == k){
                if(tail-head-1 < answer[1]-answer[0]) {
                    answer[0] = head;
                    answer[1] = tail-1;
                }                
                sum -= sequence[head++];
            } else if (sum > k) {
                sum -= sequence[head++];
            } else if (tail < sequence.length) {
                sum += sequence[tail++];
            } else {
                break;
            }
        }
        
        return answer;
    }
}