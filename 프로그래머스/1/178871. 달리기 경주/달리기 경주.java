import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++) map.put(players[i], i);
        
        for(int i=0; i<callings.length; i++) {
            String call = callings[i];
            int rank = map.get(call);
            
            String tmp = players[rank];
            players[rank] = players[rank-1];
            players[rank-1] = tmp;
            map.put(players[rank], rank);
            map.put(players[rank-1], rank-1);
        }
        
        return players;
    }
}