import java.util.*;
class Solution {
    static List<String> list;
    static String[] arr;
    
    public int solution(String word) {
        int answer = 0;
        arr = new String[]{"A", "E", "I", "O", "U"};
        list = new ArrayList<>();
        
        recur("", 0);

        for (int i = 1; i < list.size(); i++) {
            if(word.equals(list.get(i))) {
                answer = i;
            }
        }
        return answer;
    }
    
    public static void recur(String cur, int cnt) {
        list.add(cur);

        if(cnt == 5) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            recur(cur+arr[i], cnt+1);
        }
    }
}