import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] arr = new int[2];
        int zero = 0;
        int same = 0;
        
        loop:
        for(int lotto : lottos) {
            if(lotto == 0) {
                zero++;
                continue;
            }
            for(int win_num : win_nums) {
                if(lotto == win_num) {
                    same++;
                    continue loop;
                }                
            }
        }
        
        arr[0] = same + zero;
        arr[1] = same;
        
        for(int i=0; i<2; i++) {
            switch(arr[i]) {
                case 6:
                    answer[i] = 1;
                    break;
                case 5:
                    answer[i] = 2;
                    break;
                case 4:
                    answer[i] = 3;
                    break;
                case 3:
                    answer[i] = 4;
                    break;
                case 2:
                    answer[i] = 5;
                    break;
                default:
                    answer[i] = 6;
                    break;
            }
        }        
        
        return answer;
    }
}