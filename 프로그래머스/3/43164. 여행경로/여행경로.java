import java.util.*;
class Solution {
    static boolean[] v;
    static List<String> list;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        v = new boolean[tickets.length];
        list = new ArrayList<>();

        dfs(0, tickets, "ICN", "ICN");

        Collections.sort(list);
        return list.get(0).split(" ");
    }
    
    public static void dfs(int depth, String[][] tickets, String cur, String root) {
        if(depth == tickets.length) {
            list.add(root);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(!v[i] && cur.equals(tickets[i][0])) {
                v[i] = true;
                dfs(depth+1, tickets, tickets[i][1], root+" "+tickets[i][1]);
                v[i] = false;
            }
        }
    }
}