import java.util.*;
class Solution {
    static boolean[] v;
    static List<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        
        v = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(list);
        return list.get(0).split(" ");
    }
    
    public void dfs(int depth, String cur, String path, String[][] tickets) {
        if(depth == tickets.length) {
            list.add(path);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!v[i] && tickets[i][0].equals(cur)) {
                v[i] = true;
                dfs(depth+1, tickets[i][1], path + " " + tickets[i][1], tickets);
                v[i] = false;
            }
        }
    }
}