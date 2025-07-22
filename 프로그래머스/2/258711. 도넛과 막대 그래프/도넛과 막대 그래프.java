import java.util.*;
class Solution {
    static int[] out, in;
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int max = 0;
        Map<Integer, Integer> outMap = new HashMap<>();
        Map<Integer, Integer> inMap = new HashMap<>();
        
        for(int[] arr : edges) {
            max = Math.max(max, Math.max(arr[0], arr[1]));
            outMap.put(arr[0], outMap.getOrDefault(arr[0], 0) + 1);
            inMap.put(arr[1], inMap.getOrDefault(arr[1], 0) + 1);
        }
                
        for(int i=1; i<=max; i++) {
            int out = outMap.getOrDefault(i, 0);
            int in = inMap.getOrDefault(i, 0);
            
            if(out > 1) {
                if(in == 0) {
                    answer[0] = i;
                } else {
                    answer[3]++;
                }
            } else if (out == 0 && in > 0){
                answer[2]++;
            }
        }
        answer[1] = outMap.get(answer[0]) - answer[2] - answer[3];
        return answer;
    }
}