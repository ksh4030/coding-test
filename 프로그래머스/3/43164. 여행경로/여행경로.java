import java.util.*;
class Solution {
    static boolean[] v;
    List<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        v = new boolean[tickets.length];
        bt("ICN", tickets, "ICN", 0);
        
        Collections.sort(list);
        String[] answer = list.get(0).split(" ");
        return answer;
    }
    
    public void bt(String cur, String[][] tickets, String s, int depth) {
        if(depth == tickets.length) {
            list.add(s.toString());
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(tickets[i][0].equals(cur) && !v[i]) {
                v[i] = true;
                bt(tickets[i][1], tickets, s + " " + tickets[i][1], depth + 1);
                v[i] = false;
            }
        }
    }
}