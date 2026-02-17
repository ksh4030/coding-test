import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : tangerine) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        
        int sum = 0;
        int idx = 0;
        while(sum < k) {
            sum += list.get(idx++);
            answer++;
        }
        
        return answer;
    }
}