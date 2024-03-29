import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });

        int target = targets[0][1];
        answer++;
        for (int i = 1; i < targets.length; i++) {
            if(target <= targets[i][0]) {
                answer++;
                target = targets[i][1];
            }
        }
        return answer;
    }
}