import java.util.*;
class Solution {
    static String[] man = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static boolean[] v;
    static int ans;
    public int solution(int n, String[] data) {
        int answer = 0;
        v = new boolean[man.length];
        ans = 0;
        per(new ArrayList<>(), data);
        return ans;
    }
    
    public void per(List<String> list, String[] data) {
        if(list.size() == 8) {
            if(isPossible(list, data)) ans++;
            return;
        }
        
        for(int i=0; i<man.length; i++) {
            if(!v[i]) {
                v[i] = true;
                list.add(man[i]);
                per(list, data);
                list.remove(list.size() - 1);
                v[i] = false;
            }
        }
    }
    
    public boolean isPossible(List<String> list, String[] data) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<list.size(); i++) {
            map.put(list.get(i), i);
        }
        
        for(String s : data) {
            int a = map.get(String.valueOf(s.charAt(0)));
            int b = map.get(String.valueOf(s.charAt(2)));
            switch(s.charAt(3)) {
                case '=' :
                    if(Math.abs(a-b) - 1 != s.charAt(4)-'0') return false;
                    break;
                case '>' :
                    if(Math.abs(a-b) - 1 <= s.charAt(4)-'0') return false;
                    break;
                case '<' :
                    if(Math.abs(a-b) - 1 >= s.charAt(4)-'0') return false;
                    break;
            }
            
        }
        
        return true;
    }
}