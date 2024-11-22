import java.util.*;

public class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long factorialNum = 1;
        for(int i=1; i<=n; i++) {
            list.add(i);
            factorialNum *= i;
        }
        k--; //배열은 0부터 시작
        int idx = 0;
        while(idx < n) {
            factorialNum /= n - idx;
            answer[idx++] = list.remove((int) (k / factorialNum));
            k %= factorialNum;
        }

        return answer;
    }
}