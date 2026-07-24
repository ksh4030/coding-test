import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        List<Integer> list = new ArrayList<>();
        
        for(int i=3; i<sum/2; i++) if(sum % i == 0) list.add(i);
        
        int left = 0;
        int right = list.size() - 1;
        
        while(left <= right) {
            if((list.get(left)-2) * (list.get(right)-2) == yellow) {
                answer[0] = list.get(right);
                answer[1] = list.get(left);
            }
            
            left++;
            right--;
        }
        
        return answer;
    }
}