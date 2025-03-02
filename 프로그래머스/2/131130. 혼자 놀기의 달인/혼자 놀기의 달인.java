import java.util.*;
class Solution {
    static boolean[] v;
    static List<Integer> list = new ArrayList<>();
    
    public int solution(int[] cards) {
        int answer = 0;
        v = new boolean[cards.length];
        
        for(int i=0; i<cards.length; i++) {
            if(!v[i]) {
                dfs(0, i, cards);
            }
        }
        Collections.sort(list, Comparator.reverseOrder());
        return list.size() > 1 ? list.get(0) * list.get(1) : 0;
    }
    
    public void dfs(int depth, int idx, int[] cards) {
        if(v[idx]) {
            list.add(depth);
            return;
        }
        v[idx] = true;
        dfs(depth + 1, cards[idx] - 1, cards);
    }
}