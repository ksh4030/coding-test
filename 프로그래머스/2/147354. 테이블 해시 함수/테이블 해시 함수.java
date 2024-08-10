import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (int[] o1, int[] o2) -> {
            if(o1[col-1] == o2[col-1]) return o2[0] - o1[0];
            return o1[col-1] - o2[col-1];
        });
        
        int answer = 0;
        
        for(int i=row_begin-1; i<row_end; i++) {
            int num = 0;
            for(int n : data[i]) {
                num += (n % (i+1));
            }
            answer = answer ^ num;
        }
        
        return answer;
    }
}