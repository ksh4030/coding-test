import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        if(map.size() == 1) {
            answer = map.get(clothes[0][1]);
        } else {
            int n = 1;
            for(String key : map.keySet()) {
                n *= map.get(key) + 1;
            }
            answer = n - 1;
        }
        
        return answer;
    }
}