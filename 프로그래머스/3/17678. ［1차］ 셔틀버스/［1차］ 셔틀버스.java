import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int start = 540;
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        StringToInt(timetable);
        
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<m; j++) {
                if(!pq.isEmpty() && pq.peek() <= start) pq.poll();
            }
            start += t;
        }
        
        int cnt = 0;
        int last = 0;
        for(int i=0; i<m; i++) {
            if(!pq.isEmpty() && pq.peek() <= start) {
                last = pq.poll();
                cnt++;
            }
        }
        
        if(cnt < m) {
            answer = intToString(start);
        } else {
            answer = intToString(last - 1);
        }
        
        return answer;
    }
    
    public String intToString(int time) {
        int h = time / 60;
        int m = time % 60;
        
        return String.format("%02d:%02d", h, m);
    }
    
    public void StringToInt(String[] timetable) {
        for(String s : timetable) {
            String[] arr = s.split(":");
            pq.add(Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]));
        }
    }
}