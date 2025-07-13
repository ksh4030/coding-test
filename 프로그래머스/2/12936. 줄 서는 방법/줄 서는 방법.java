import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long num = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            num *= i;
            list.add(i);
        }
        int idx = 0;
        k--;
        while(idx < n) {
            num /= n - idx;
            answer[idx++] = list.remove((int)(k / num));
            k %= num;
        }
        
        return answer;
    }
}