import java.util.*;
class Solution {
    static boolean[][] board;
    static boolean[] v;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        board = new boolean[n+1][n+1];
        v = new boolean[n+1];
        
        for(int[] e : edge) {
            board[e[0]][e[1]] = true;
            board[e[1]][e[0]] = true;
        }
        
        return bfs();
    }
    
    public int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0));
        v[1] = true;
        
        int max = 0;
        int cnt = 0;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for(int i=1; i<board[cur.num].length; i++) {
                if(board[cur.num][i] && !v[i]) {
                    q.add(new Node(i, cur.cnt+1));
                    v[i] = true;
                    if(max == cur.cnt+1) {
                        cnt++;
                    } else if (max < cur.cnt+1) {
                        max = cur.cnt+1;
                        cnt = 1;
                    }
                }
            }
        }
        
        return cnt;
    }

    class Node {
        int num, cnt;
        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}