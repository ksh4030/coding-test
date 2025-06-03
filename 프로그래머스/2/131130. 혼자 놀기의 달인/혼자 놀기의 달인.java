import java.util.*;

class Solution {
    static List<Integer> list = new ArrayList<>();
    static boolean[] v;
    public int solution(int[] cards) {
        int answer = 0;
        v = new boolean[cards.length];
        
        for(int i=0; i<cards.length; i++) {
            if(!v[i]) findCycle(i, 0, cards);
        }
        
        if(list.size() < 2) return 0;
        
        Collections.sort(list, Comparator.reverseOrder());
        return list.get(0) * list.get(1);
    }
    
    public void findCycle(int cur, int cnt, int[] cards) {
        if(v[cur]) {
            list.add(cnt);
            return;
        }
        
        v[cur] = true;
        findCycle(cards[cur]-1, cnt+1, cards);
    }
}