import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};
        int[] answer = new int[n];
        int base = s / n;
        int extra = s % n;
        Arrays.fill(answer, base);
        
        for(int i=n-1; i>=n-extra; i--) {
            answer[i]++;
        }
        
        return answer;
    }
}