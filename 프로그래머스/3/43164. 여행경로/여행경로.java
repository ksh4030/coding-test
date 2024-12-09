import java.util.*;
class Solution {
    static List<String> list = new ArrayList<>();
    static boolean[] v;
    public String[] solution(String[][] tickets) {
        v = new boolean[tickets.length];
        
        dfs(tickets, "ICN", "ICN", 0);
        
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    
    public void dfs(String[][] tickets, String cur, String ans, int depth) {
        if(depth == tickets.length) {
            list.add(ans);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!v[i] && cur.equals(tickets[i][0])) {
                v[i] = true;
                dfs(tickets, tickets[i][1], ans+" "+tickets[i][1], depth+1);
                v[i] = false;
            }
        }
    }
}