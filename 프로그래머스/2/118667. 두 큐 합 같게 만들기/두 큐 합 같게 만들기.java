import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;

        for (int n : queue1) {
            q1.add(n);
            sum1+=n;
        }
        for (int n : queue2) {
            q2.add(n);
            sum2+=n;
        }
        if((sum1+sum2)%2 != 0) return -1;
        long target = (sum1 + sum2)/2;

        long cnt = 0;
        while (cnt < (queue1.length + queue2.length)*2) {
            if(sum1 == target && sum2 == target) {
                answer = (int)cnt;
                break;
            } else if (sum1 > sum2) {
                int n = q1.poll();
                sum1-=n;
                sum2+=n;
                q2.add(n);
            } else if(sum2 > sum1) {
                int n = q2.poll();
                sum2-=n;
                sum1+=n;
                q1.add(n);
            }
            cnt++;
        }
        return cnt >= (queue1.length + queue2.length)*2 ? -1 : answer;
    }
}