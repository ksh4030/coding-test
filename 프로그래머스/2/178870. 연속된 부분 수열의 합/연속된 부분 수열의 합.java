import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        if(k == sequence[0]) return new int[]{0,0};
        
        int start = 0;
        int end = 1;
        
        int sum = sequence[0] + sequence[1];
        int curSize = 2;
        int minSize = Integer.MAX_VALUE;
        
        while(true) {
            if(start > end) break;
            if(end > sequence.length) break;
            try {
                if(sum < k) {
                     end++;
                     curSize++;
                     sum += sequence[end];
                 } else if (sum > k) {
                     sum -= sequence[start];
                     start++;
                     curSize--;
                 } else {
                    if(minSize > curSize) {
                        answer[0] = start;
                        answer[1] = end;
                        minSize = curSize;
                    }
                    sum -= sequence[start];
                    start++;
                    curSize--;                    
                 }
            } catch (Exception e) {
                break;
            }
            
        }
        
        return answer;
    }
}