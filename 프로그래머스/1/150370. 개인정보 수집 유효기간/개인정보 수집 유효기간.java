import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {        
        List<Integer> list = new ArrayList<>();
        
        int todayInt = changeDate(today);
        
        for(int i=0; i<privacies.length; i++) {
            String[] bucket = privacies[i].split(" ");
            int curDate = changeDate(bucket[0]);
            for(int j=0; j<terms.length; j++) {
                String[] arr = terms[j].split(" ");
                if(arr[0].equals(bucket[1])) {
                    curDate += Integer.parseInt(arr[1]) * 28;
                }
            }
            
            if(todayInt >= curDate) {
                list.add(i+1);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public static int changeDate(String s) {
        String[] dateArr = s.split("\\.");
        return Integer.parseInt(dateArr[0])*12*28 + Integer.parseInt(dateArr[1])*28 + Integer.parseInt(dateArr[2]);
    }
}