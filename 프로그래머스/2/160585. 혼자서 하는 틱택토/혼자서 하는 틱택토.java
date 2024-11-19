import java.util.*;
class Solution {
    static String[][] map = new String[3][3];
    public int solution(String[] board) {        
        for(int i=0; i<board.length; i++) map[i] = board[i].split("");        
        return isPossible() ? 1 : 0;
    }
    
    public boolean isPossible() {
        int cntO = 0, cntX = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(map[i][j].equals("O")) cntO++;
                if(map[i][j].equals("X")) cntX++;
            }
        }
        boolean correctO = correct("O");
        boolean correctX = correct("X");        
        
        if(cntX > cntO) return false;
        if(Math.abs(cntX - cntO) >= 2) return false;
        if(correctO && correctX) return false;
        if(correctX && (cntO > cntX)) return false;
        if(correctO && (cntO == cntX)) return false;
        
        return true;
    }
    
    public boolean correct(String target) {
        for(int i=0; i<3; i++) {
            if(map[i][0].equals(target)) {
                if(map[i][1].equals(target) && (map[i][2]).equals(target)) return true;
            }
            if(map[0][i].equals(target)) {
                if(map[1][i].equals(target) && (map[2][i]).equals(target)) return true;
            }            
        }
        
        if(map[0][0].equals(target) && map[1][1].equals(target) && map[2][2].equals(target)) return true;
        if(map[0][2].equals(target) && map[1][1].equals(target) && map[2][0].equals(target)) return true;
        
        return false;
    }
}