import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        answer[1] = gems.length;
        
        Map<String, Integer> map = new HashMap<>();
        for(String s : gems) {
            map.put(s, 1);
        }
        // map.getOrDefault(map.get(s), 0) + 1
        
        if(map.size() == 1) return new int[]{1, 1};
        
        int left = 0;
        int right = 0;
        int cnt = map.size();
        
        while(right < gems.length || cnt == 0) {
            if(cnt == 0) {
                if(right - left < answer[1] - answer[0] + 1) {
                    answer[0] = left + 1;
                    answer[1] = right;
                }
                int n = map.get(gems[left]) + 1;
                if(n > 0) cnt++;
                map.put(gems[left], n);
                
                left++;
            } else {
                map.put(gems[right], map.get(gems[right]) - 1);
                if(map.get(gems[right]) == 0) cnt--;
                right++;
            }
        }
        
        return answer;
    }
}