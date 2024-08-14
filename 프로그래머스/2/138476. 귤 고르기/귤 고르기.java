import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 1;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : tangerine) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);        
        Collections.reverse(list);
        
        int num = 0;
        int idx = 0;
        while(true) {
            num += list.get(idx);
            if(num >= k)break;
            idx++;
            answer++;
        }
        
        return answer;
    }
}