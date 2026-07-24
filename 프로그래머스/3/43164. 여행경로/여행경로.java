import java.util.*;
class Solution {
    static List<String> list = new ArrayList<>();
    static int cnt;
    static boolean[] v;
    static Map<String, Integer> map;
    
    public String[] solution(String[][] tickets) {
        String[] answer = new String[1];
        v = new boolean[tickets.length];
        
        dfs("ICN", tickets, 0, "ICN");
        
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    public void dfs(String start, String[][] tickets, int cnt, String bucket) {
        if(cnt == tickets.length) {
            list.add(bucket);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!v[i] && tickets[i][0].equals(start)) {
                v[i] = true;
                dfs(tickets[i][1], tickets, cnt+1, bucket + " " + tickets[i][1]);
                v[i] = false;
            }
        }
    }
}