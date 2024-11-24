import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> man = new HashMap<>();
        Map<Integer, String> rank = new HashMap<>();
        
        int cnt = 1;
        for(int i=0; i<players.length; i++) {
            man.put(players[i], cnt);
            rank.put(cnt, players[i]);
            cnt++;
        }
        
        for(int i=0; i<callings.length; i++) {
            String cur = callings[i];
            int curRank = man.get(cur);
            
            String target = rank.get(curRank-1);
            int targetRank = curRank-1;
            
            man.put(cur, targetRank);
            man.put(target, curRank);
            rank.put(targetRank, cur);
            rank.put(curRank, target);
        }
        
        for(int i=1; i<=cnt-1; i++) {
            answer[i-1] = rank.get(i);
        }
        return answer;
    }
}