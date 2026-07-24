import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] mans = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] nums = new int[3];
        int max = -1;        
        
        for(int i=0; i<3; i++) {
            int idx = 0;
            int cnt = 0;
            
            for(int j=0; j<answers.length; j++) {
                if(answers[j] == mans[i][idx++]) {
                    cnt++;
                }
                if(idx == mans[i].length) idx = 0;
            }
            
            nums[i] = cnt;
            max = Math.max(max, cnt);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<mans.length; i++) {
            if(nums[i] == max) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}