import java.util.*;

class Solution {
    final static int NINE = 540; // 09:00 in minutes
    
    public String solution(int n, int t, int m, String[] timetable) {
        // 1. timetable을 분으로 변환하여 정렬
        int[] time = new int[timetable.length];
        for (int i = 0; i < time.length; i++) {
            time[i] = tToI(timetable[i]);
        }
        Arrays.sort(time);
        
        int idx = 0; // timetable의 인덱스
        int cur = NINE; // 현재 셔틀의 도착 시각 (분 단위)
        
        // 2. 셔틀이 n-1번 도착할 때까지 크루를 태움
        for (int i = 0; i < n - 1; i++) {
            int capacity = m;
            while (idx < time.length && time[idx] <= cur && capacity > 0) {
                idx++;
                capacity--;
            }
            cur += t;
        }
        
        // 3. 마지막 셔틀의 경우
        int capacity = m;
        while (idx < time.length && time[idx] <= cur && capacity > 0) {
            idx++;
            capacity--;
        }
        
        // 4. 콘이 탈 수 있는 가장 늦은 시간을 계산
        if (capacity > 0) {
            // 셔틀에 자리가 남아있는 경우
            return iToT(cur);
        } else {
            // 셔틀에 자리가 없는 경우, 마지막으로 탄 크루보다 1분 빨리 도착해야 함
            return iToT(time[idx - 1] - 1);
        }
    }
    
    // HH:MM 형식을 분으로 변환
    public int tToI(String s) {
        String[] bucket = s.split(":");
        return Integer.parseInt(bucket[0]) * 60 + Integer.parseInt(bucket[1]);
    }
    
    // 분을 HH:MM 형식으로 변환
    public String iToT(int n) {
        int hours = n / 60;
        int minutes = n % 60;
        return String.format("%02d:%02d", hours, minutes);
    }
}
