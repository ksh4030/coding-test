import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int max = attacks[attacks.length-1][0];
        
        int continuous = 0;
        int idx = 0;
        int H = health;
        for(int i=attacks[0][0]; i<=max; i++) {
            if(i == attacks[idx][0]) {
                health -= attacks[idx][1];
                if(health <= 0) return -1;
                idx++;
                continuous = 0;
                continue;
            } else {
                continuous++;
                if(continuous == bandage[0]) {
                    health += bandage[1]+bandage[2];
                    if(health > H) health = H;
                    continuous = 0;
                } else {
                    health += bandage[1];
                    if(health > H) health = H;
                }
            }            
        }
        return health;
    }
}