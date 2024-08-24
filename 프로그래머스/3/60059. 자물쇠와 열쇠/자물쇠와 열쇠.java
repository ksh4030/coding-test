import java.util.*;
class Solution {
    static int[][] map;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        map = new int[lock.length + ((key.length-1)*2)][lock[0].length + ((key[0].length-1)*2)];
        makeMap(key, lock);
        
        for(int i=0; i<4; i++) {
            if(checkMap(key)) return true;
            key = trunKey(key);
        }        
        return false;
    }
    
    public static int[][] trunKey(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] rotate = new int[m][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = arr[n-1-j][i];
            }
        }

        return rotate;        
    }
    
    public static boolean checkMap(int[][] key) {
        for(int i=0; i<map.length - key.length + 1; i++) {
            for(int j=0; j<map[0].length-key[0].length+1; j++) {
                int[][] newMap = new int[map.length][map[0].length];
                for (int a = 0; a < map.length; a++) {
                    newMap[a] = map[a].clone();
                }
                loop:
                for(int r=0; r<key.length; r++) {
                    for(int c=0; c<key.length; c++) {
                        if(map[i+r][j+c] == 1 && key[r][c] == 1) break loop;
                        if(newMap[i+r][j+c] == 0 && key[r][c] == 1) {
                            newMap[i+r][j+c] = 1;
                        }
                    }
                }                
                if(possible(newMap, key)) return true;
            } 
        }        
        return false;
    }
    
    public static boolean possible(int[][] newMap, int[][] key) {
        for(int i=key.length-1; i<newMap.length - key.length+1; i++) {
            for(int j=key[0].length-1; j<newMap.length - key.length+1; j++) {
                if(newMap[i][j]==0) return false;
            }
        }        
        return true;
    }
    
    public static void makeMap(int[][] key, int[][] lock) {
        for(int i=0; i<lock.length; i++) {
            for(int j=0; j<lock[0].length; j++) {
                if(lock[i][j] == 1) {
                    map[i+key.length-1][j+key[0].length-1] = 1;
                }
            }
        }
    }
}