import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=l; i<=r; i++) {
            String[] arr = Integer.toString(i).split("");
            boolean flag = true;
            for(int j=0; j<arr.length; j++) {
                if(!arr[j].equals("0") && !arr[j].equals("5")) {
                    flag = false;
                    break;
                }
            }
            if(flag) list.add(i);
        }
        
        if(list.size() == 0) {
            int[] a = {-1};
            return a;
        }
            
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}