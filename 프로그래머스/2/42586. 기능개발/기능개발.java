import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> sq = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            q.add(progresses[i]);
            sq.add(speeds[i]);
        }

        while (!q.isEmpty()) {
            int cnt = 0;
            for (int i = 0; i < q.size(); i++) {
                int cur = q.poll();
                int curSpeed = sq.poll();

                q.add(cur + curSpeed);
                sq.add(curSpeed);
            }

            while (!q.isEmpty()) {
                if(q.peek() >= 100) {
                    q.poll();
                    sq.poll();
                    cnt++;
                    if(q.isEmpty()) {
                        list.add(cnt);
                    }
                } else {
                    if(cnt > 0) {
                        list.add(cnt);
                    }
                    break;
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}