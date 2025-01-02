import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static List<Integer> list = new ArrayList<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayTime = StringToInt(today);
        makeMap(terms);
        checkPossible(todayTime, privacies);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void checkPossible(int todayTime, String[] privacies) {
        for(int i=0; i<privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            int curTime = StringToInt(arr[0]);
            String curKind = arr[1];
            
            if(isPossible(curTime, todayTime, curKind)) list.add(i+1);
        }
    }
    
    public boolean isPossible(int curTime, int todayTime, String curKind) {
        if(todayTime - curTime >= map.get(curKind)) return true;
        return false;
    }
    
    public void makeMap(String[] terms) {
        for(String s : terms) {
            String[] arr = s.split(" ");
            
            int time = Integer.parseInt(arr[1]) * 28;
            map.put(arr[0], time);
        }
    }
    
    public int StringToInt(String s) {
        String[] arr = s.split("\\.");
        int n = 0;
        
        n += Integer.parseInt(arr[0]) * 12 * 28;
        n += Integer.parseInt(arr[1]) * 28;
        n += Integer.parseInt(arr[2]);
        
        return n;
    }
}