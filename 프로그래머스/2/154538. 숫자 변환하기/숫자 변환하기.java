import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[y+1];
        q.add(x);
        v[x] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();

                if(cur == y) {
                    return answer;
                }

                if(cur * 2 <= y && !v[cur*2]) {
                    q.add(cur*2);
                    v[cur*2] =true;
                }
                if(cur * 3 <= y && !v[cur*3]){
                    q.add(cur*3);
                    v[cur*3]=true;
                }
                if(cur + n <= y && !v[cur+n]){                    
                    q.add(cur+n);
                    v[cur+n]=true;
                }
            }

            answer++;
        }
        return -1;
    }
}