import java.util.*;
class Solution {
    static boolean[] v;
    static Set<List<String>> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        v = new boolean[user_id.length];
        dfs(user_id, banned_id, 0, new ArrayList<>());
        
        // System.out.println(set);
        return set.size();
    }
    
    public void dfs(String[] user_id, String[] banned_id, int idx, List<String> list) {
        if(idx >= banned_id.length) {
            Collections.sort(list);
            set.add(List.copyOf(list));
            return;
        }
        
        for(int i=0; i<user_id.length; i++) {
            if(!v[i] && isPossible(user_id[i], banned_id[idx])) {
                v[i] = true;
                list.add(user_id[i]);
                dfs(user_id, banned_id, idx+1, list);
                list.remove(user_id[i]);
                v[i] = false;
            }
        }
    }
    
    public boolean isPossible(String user, String target) {
        if(user.length() != target.length()) return false;
        for(int i=0; i<user.length(); i++) {
            if(target.charAt(i) == '*') continue;
            if(user.charAt(i) != target.charAt(i)) return false;
        }
        
        return true;
    }
    
    class Node {
        int num;
        public Node(int num) {
            this.num = num;
        }
    }
}