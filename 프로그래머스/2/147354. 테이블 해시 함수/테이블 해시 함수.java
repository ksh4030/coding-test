import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (o1, o2) -> o1[col-1] == o2[col-1] ? o2[0]-o1[0] : o1[col-1]-o2[col-1]);

        for (int i = row_begin-1; i <= row_end-1; i++) {
            int bucket = 0;
            for (int n : data[i]) bucket += (n%(i+1));
            answer = answer ^ bucket;
        }
        return answer;
    }
}