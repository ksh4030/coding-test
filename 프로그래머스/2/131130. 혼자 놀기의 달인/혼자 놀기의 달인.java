import java.util.*;
class Solution {
        static boolean[] v;
    static PriorityQueue<Integer> list;
    public int solution(int[] cards) {
        int answer = 0;
        v = new boolean[cards.length];
        list = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < cards.length; i++) {
            if(!v[i]) {
                dfs(1,i, 0, cards);
            }
        }
        if(list.size() != 1) return list.poll() * list.poll();
        return 0;
        
    }
    
        public static void dfs(int depth, int i, int cnt, int[] cards) {
        if(v[i]) {
            list.add(cnt);
            if(depth == v.length) {
                list.add(0);
            }
            return;
        }
        v[i] = true;
        dfs(0,cards[i]-1, cnt+1, cards);
    }
}