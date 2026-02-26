import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        
        for(long i=0; i<(right - left + 1); i++) {
            long r = (left + i) % n;
            long c = (left + i) / n;
            
            answer[(int)i] = Math.max((int)r, (int)c) + 1;
        }
        
        return answer;
    }
}