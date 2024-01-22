import java.util.*;
class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
            Queue<Integer> bridge = new LinkedList<>();
        for(int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }

        int index = 0;
        int currentWeight = 0;
        while(index < truck_weights.length){
            currentWeight -= bridge.poll();
            answer++;
            if(currentWeight + truck_weights[index] <= weight){
                bridge.offer(truck_weights[index]);
                currentWeight += truck_weights[index++];
            } else{
                bridge.offer(0);
            }
        }
        return answer+bridge_length;
    }
}