import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (Arrays.asList(words).contains(target)) {
            answer = bfs(begin, target, words);
        }        
        return answer;
    }
    
    public static int bfs(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(begin, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.s.equals(target)) {
                return cur.cnt;
            }

            for (int i = 0; i < words.length; i++) {
                if(diff(cur.s, words[i])) {
                    q.add(new Node(words[i], cur.cnt+1));
                }
            }
        }
        return 0;
    }

    public static boolean diff(String a, String b) {
        String[] arr1 = a.split("");
        String[] arr2 = b.split("");
        int cnt = 0;

        for (int i = 0; i < arr1.length; i++) {
            if(!arr1[i].equals(arr2[i])) cnt++;
        }

        if(cnt == 1) return true;
        else return false;
    }

    static class Node {
        String s;
        int cnt;
        public Node(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }
}