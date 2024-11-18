import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        
        for(int n : weights) {
            double a = n * 1.0;
            double b = (n * 1.0) / 2.0;
            double c = (n * 2.0) / 3.0;
            double d = (n * 3.0) / 4.0;
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        return answer;
    }
}