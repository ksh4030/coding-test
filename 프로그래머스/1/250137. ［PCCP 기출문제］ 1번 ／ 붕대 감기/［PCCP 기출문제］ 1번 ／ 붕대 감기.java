class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int idx = 0;
        int time = 1;
        int cnt = 0;
        int cur = health;
        while(idx < attacks.length) {
            cnt++;
            if(attacks[idx][0] == time) {
                cur -= attacks[idx][1];
                if(cur <= 0) return -1;
                idx++;
                cnt = 0;
            } else {                
                if(cnt == bandage[0]) {
                    cur += bandage[2];
                    cnt = 0;
                }
                cur += bandage[1];
            }
            time++;
            if(cur > health) cur = health;
        }     
        return cur;
    }
}