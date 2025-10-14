class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        long time1 = (h1 * 3600) + (m1 * 60) + s1;
        long time2 = (h2 * 3600) + (m2 * 60) + s2;

        return (int) (cntAlarm(time2) - cntAlarm(time1) + (time1 % 3600 == 0 ? 1 : 0));
    }
    
    public long cntAlarm(long time) {
        long secMin = (time * 59) / 3600 + 1;
        long secHour = (time * 719) / 43200 + 1;
        long secMinHour = (time / 43200) + 1;
        
        return secMin + secHour - secMinHour;
    }
}