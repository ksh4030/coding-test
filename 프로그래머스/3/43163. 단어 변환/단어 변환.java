import java.util.*;
class Solution {
    static boolean[] v;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        v = new boolean[words.length];
        return bfs(begin, target, words);
    }
    
    public int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            // System.out.println("-----------------------------");
            // System.out.println(cur.word);
            // System.out.println(cur.cnt);
            // System.out.println("-----------------------------");
            if(cur.word.equals(target)) return cur.cnt;
            
            for(int i=0; i<words.length; i++) {
                if(!v[i] && !words[i].equals(cur.word) && isPossible(cur.word, words[i])){
                    q.add(new Node(words[i], cur.cnt+1));
                    v[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    public boolean isPossible(String cur, String word) {
        int cnt = 0;
        for(int i=0; i<cur.length(); i++) {
            if(cur.charAt(i) != word.charAt(i)) {
                cnt++;
            }
            if(cnt > 1) return false;
        }
        
        return true;
    }
    
    class Node {
        String word;
        int cnt;
        public Node (String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}