import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) {
            return cities.length * 5;
        }

       List<String> list = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String s = cities[i].toLowerCase();

            if(list.remove(s)) {
                answer+=1;
                list.add(s);
            } else {
                answer += 5;
                if(list.size() >= cacheSize) {
                    list.remove(0);
                }
                list.add(s);
            }
        }
        return answer;
    }
}