import java.util.*;
class Solution {
    static List<String> list = new ArrayList<>();
    static boolean[] v;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        v = new boolean[tickets.length];        
        bfs(tickets, "ICN", "ICN", 0);
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    
    public void bfs(String[][] tickets, String cur, String ans, int depth) {
        if(depth == tickets.length) {
            list.add(ans);
            return;
        }
        for(int i=0; i<tickets.length; i++) {
            if(!v[i] && cur.equals(tickets[i][0])) {
                v[i] = true;
                bfs(tickets, tickets[i][1], ans + " " + tickets[i][1], depth+1);
                v[i] = false;
            }
        }
    }
}