import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int video_len_i = stringToInt(video_len);
        int pos_i = stringToInt(pos);
        int op_start_i = stringToInt(op_start);
        int op_end_i = stringToInt(op_end);
        
        for(String s : commands) {
            if(pos_i >= op_start_i && pos_i <= op_end_i) pos_i = op_end_i;
            
            if(s.equals("next")) {
                pos_i += 10;
                if(pos_i > video_len_i) pos_i = video_len_i;
            } else if(s.equals("prev")) {
                pos_i -= 10;
                if(pos_i < 0) pos_i = 0;
            } 
        }
        if(pos_i >= op_start_i && pos_i <= op_end_i) pos_i = op_end_i;
        return intToString(pos_i);
    }
    
    public static int stringToInt(String time) {
        String[] arr = time.split(":");
        return (Integer.parseInt(arr[0])*60) + Integer.parseInt(arr[1]);
    }
    
    public static String intToString(int time) {
        String a = Integer.toString(time/60);
        if(a.length() == 1) a = "0" + a;
        String b = Integer.toString(time%60);
        if(b.length() == 1) b = "0" + b;
        return a + ":" + b;
    }
}