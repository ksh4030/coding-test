import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] time = new int[book_time.length][2];

        for (int i = 0; i < time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", "")) + 10;

            if(end % 100 >= 60) {
                end += 40;
            }
            time[i][0] = start;
            time[i][1] = end;
        }

        Arrays.sort(time, (o1, o2) -> {
            return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < time.length; i++) {
            if(pq.size() <= 0) {
                pq.add(time[i][1]);
                continue;
            }

            int firstRoom = pq.peek();
            if(firstRoom > time[i][0]) {
                pq.add(time[i][1]);
            } else {
                pq.poll();
                pq.add(time[i][1]);
            }
        }
        return pq.size();
    }
}