import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        HashMap<String, Integer> player = new HashMap<>();
        HashMap<Integer, String> grade = new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            player.put(players[i], i);
            grade.put(i, players[i]);
        } 
        
        for(String s : callings) {
            int g = player.get(s);
            String cur = grade.get(g);
            String next = grade.get(g-1);
            
            players[g-1] = cur;
            players[g] = next;
            
            player.put(next, g);
            player.put(cur, g-1);
            grade.put(g, next);
            grade.put(g-1, cur);
        }
        
        return players;
    }
}