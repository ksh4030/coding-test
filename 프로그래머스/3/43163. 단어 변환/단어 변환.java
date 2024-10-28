import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {        
        int answer = 0;
        if(Arrays.asList(words).contains(target)) answer = bfs(begin, target, words);
        return answer;
    }
    
    public int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(target.equals(cur.s)) return cur.cnt;
            
            for(int i=0; i<words.length; i++) {
                if(diff(cur.s, words[i])) {
                    q.add(new Node(words[i], cur.cnt+1));
                }
            }
        }
        
        return 0;
    }
    
    public boolean diff(String s, String word) {
        int cnt = 0;
        for(int i=0; i<word.length(); i++) {
            if(s.charAt(i) != word.charAt(i)) cnt++;
            if(cnt > 1) return false;
        }
        return true;
    }
    
    class Node {
        String s;
        int cnt;
        public Node(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }
}