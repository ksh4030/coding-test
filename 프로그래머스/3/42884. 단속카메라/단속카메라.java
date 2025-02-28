import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        System.out.println(Arrays.deepToString(routes));
        
        int cur = routes[0][1];
        
        for(int i=1; i<routes.length; i++) {
            if(cur < routes[i][0]) {
                answer++;
                cur = routes[i][1];
            }
        }
        
        return answer+1;
    }
}