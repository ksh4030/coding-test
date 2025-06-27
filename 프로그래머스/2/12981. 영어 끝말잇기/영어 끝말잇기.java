import java.util.*;
class Solution {
    static List<String> list = new ArrayList<>();
    static int man = 1;
    static int cnt = 1;
    
    public int[] solution(int n, String[] words) {
        list.add(words[0]);
        
        for(int i=1; i<words.length; i++) {
            man++;
            if (man > n) {
                man = 1;
                cnt++;
            }
            
            if(!isPossible(words[i])) {
                return new int[]{man, cnt};
            } else {
                list.add(words[i]);
            }
        }

        return new int[]{0,0};
    }
    
    public boolean isPossible(String s) {
        String last = list.get(list.size() - 1);
        char lastChar = last.charAt(last.length() - 1);
        
        return !list.contains(s) && lastChar == s.charAt(0);
    }
}