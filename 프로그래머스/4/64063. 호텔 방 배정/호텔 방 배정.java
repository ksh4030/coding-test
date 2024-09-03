import java.util.*;
class Solution {
    static Map<Long, Long> map = new HashMap<>();
    public long[] solution(long k, long[] room_number) {
        long[] answer = room_number;
        
        for(int i=0; i<room_number.length; i++) {
            answer[i] = recur(room_number[i]);
        }
        
        return answer;
    }
    
    public static long recur (long num) {
        if(!map.containsKey(num)) {
            map.put(num, num+1);
            return num;
        }
        
        long next = map.get(num);
        long empty = recur(next);
        map.put(num, empty);
        return empty;
    }
}