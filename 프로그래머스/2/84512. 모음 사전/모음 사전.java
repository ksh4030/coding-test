import java.util.*;

class Solution {
    static String[] arr = {"A", "E", "I", "O", "U"};
    static List<String> list;
    
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        recur("");
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }       
        
        return answer;
    }
    
    public void recur(String s) {
        list.add(s);        
        if(s.length() == 5) {
            return;
        }
        
        for(int i=0; i<arr.length; i++) {
            recur(s+arr[i]);
        }
    } 
}