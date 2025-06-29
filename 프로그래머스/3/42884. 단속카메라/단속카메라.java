import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        boolean[] used = new boolean[routes.length];
        used[0] = true;
        int[] cur = routes[0];
        
        System.out.println(Arrays.deepToString(routes));
        
        for(int i=1; i<routes.length; i++) {
            if(cur[1] < routes[i][0]) {
                answer++;
                cur = routes[i];
            }
        }
        
        return answer+1;
    }
}