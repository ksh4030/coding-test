import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Map<String, Integer> stand = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : gems) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            stand.put(s, stand.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);
        int cnt = map.size() - 1;
        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        
        map.put(gems[left], map.get(gems[left]) - 1);
        System.out.println(map);
        
        while(left <= right) {
            if(cnt == 0) {
                if(right - left < min) {
                    min = right - left;
                    answer[0] = left+1;
                    answer[1] = right+1;
                }
                map.put(gems[left], map.get(gems[left]) + 1);
                int a = stand.get(gems[left]);
                int b = map.get(gems[left]);
                if(a == b) cnt++;
                left++;
            } else {
                right++;
                if(right >= gems.length) break;
                            
                map.put(gems[right], map.get(gems[right]) - 1);
                int a = stand.get(gems[right]);
                int b = map.get(gems[right]) + 1;
                if(a == b) cnt--;
            }
            
            // System.out.println("============================");
            // System.out.println(left);
            // System.out.println(right);
            // System.out.println(map);
            // System.out.println(cnt);
            // System.out.println("============================");
        }
        
        return answer;
    }
}