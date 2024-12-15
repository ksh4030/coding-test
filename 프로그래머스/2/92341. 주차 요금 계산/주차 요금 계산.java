import java.util.*;
class Solution {    
    static Map<String, Integer> map = new HashMap<>();
    static Map<String, Integer> info = new HashMap<>();
    static Set<String> carNumbers = new HashSet<>();
    public int[] solution(int[] fees, String[] records) {
        for(int i=0; i<records.length; i++) {
            String[] arr = records[i].split(" ");
            cal(arr);
        }
        
        List<String> list = new ArrayList<>(carNumbers); 
        Collections.sort(list);
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {            
            int time = map.getOrDefault(list.get(i), 0);
            int bucket = info.getOrDefault(list.get(i), -1);
            if(bucket >= 0) {
                time += calLastTime(bucket);
            }
            answer[i] = timeToMoney(fees, time);
        }
        
        return answer;
    }
    
    public void cal(String[] arr) {
        String carNum = arr[1];
        int time = StringToTime(arr[0]);
        if(arr[2].equals("IN")) {
            info.put(carNum, time);
            carNumbers.add(carNum);
        } else {
            int inTime = info.get(carNum);
            info.remove(carNum);
            time -= inTime;
            map.put(carNum, map.getOrDefault(carNum, 0) + time);
        }
    }
    //기본시간, 기본요금, 단위시간, 단위요금
    public int timeToMoney(int[] fees, int time) {
        int money = 0;
        if(time > fees[0]) {
            time -= fees[0];
            money += fees[1];
        } else {
            return fees[1];
        }
        
        time = time%fees[2] > 0 ? time/fees[2]+1 : time/fees[2];
        money += time * fees[3];
        
        return money;
    }
    
    public int StringToTime(String s) {
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    public int calLastTime(int n) {
        int time = 23*60 + 59;
        time -= n;
        return time;
    }
}