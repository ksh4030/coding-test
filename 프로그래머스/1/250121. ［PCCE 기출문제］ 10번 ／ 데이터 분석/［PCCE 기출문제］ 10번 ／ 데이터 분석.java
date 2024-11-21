import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {        
        List<int[]> list = new ArrayList<>();
        
        int target = -1;
        if(ext.equals("code")) target = 0;
        if(ext.equals("date")) target = 1;
        if(ext.equals("maximum")) target = 2;
        if(ext.equals("remain")) target = 3;
        
        for(int i=0; i<data.length; i++) {
            if(data[i][target] < val_ext) list.add(data[i]);
        }
        
        Collections.sort(list, (o1, o2) -> {
            if(sort_by.equals("code")) return o1[0] - o2[0];
            if(sort_by.equals("date")) return o1[1] - o2[1];
            if(sort_by.equals("maximum")) return o1[2] - o2[2];
            if(sort_by.equals("remain")) return o1[3] - o2[3];
            return o1[0] - o2[0];
        });
        
        int[][] answer = new int[list.size()][4];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}