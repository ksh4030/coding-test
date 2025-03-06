import java.util.*;
class Solution {
    static int[][] storage;
    public int solution(int n, int w, int num) {
        int answer = 0;
        stackBox(n, w);
        Pos pos = findPos(num);
        
        for(int i=pos.r; i>=0; i--) {
            if(storage[i][pos.c] != 0) answer++; 
        }
        
        return answer;
    }
    
    public Pos findPos(int num) {
        for(int i=0; i<storage.length; i++) {
            for(int j=0; j<storage[i].length; j++) {
                if(storage[i][j] == num) {
                    return new Pos(i, j);
                }
            }
        }
        
        return new Pos(-1, -1);
    }
    
    public void stackBox(int n, int w) {
        storage = new int[n%w>0 ? n/w+1 : n/w][w];
        int x = 1;
        boolean flag = false;
        
        for(int i=storage.length-1; i>=0; i--) {
            if(!flag) {
                for(int j=0; j<storage[i].length; j++) {
                    storage[i][j] = x++;
                    if(x > n) return;
                }
            } else {
                for(int j=storage[i].length-1; j>=0; j--) {
                    storage[i][j] = x++;
                    if(x > n) return;
                }
            }
            
            flag = !flag;
        }
    }
    
    class Pos{
        int r, c;
        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}