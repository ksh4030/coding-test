import java.util.*;
class Solution {
    static int standardTime;
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Arrays.sort(plans, (o1, o2) -> Integer.compare(toInt(o1[1]), toInt(o2[1])));
        System.out.println(Arrays.deepToString(plans));
        Stack<String[]> stack = new Stack<>();
        int idx = 0;
        standardTime = 0;
        
        for(int i=0; i<plans.length-1; i++) {
            String[] cur = plans[i].clone();
            String[] next = plans[i+1].clone();
            int curTime = toInt(cur[1]);
            int nextTime = toInt(next[1]);
            int playTime = Integer.parseInt(cur[2]);
            
            if(curTime+playTime > nextTime) {
                cur[2] = Integer.toString(curTime+playTime - nextTime);
                stack.add(cur);
                standardTime = nextTime;
            } else {
                answer[idx++] = cur[0];
                standardTime = curTime + playTime;
                
                if(standardTime < nextTime) {
                    int n = nextTime - standardTime;
                    while(!stack.isEmpty()) {
                        if(n <= 0) break;
                        String[] bucket = stack.pop();
                        // System.out.println(Arrays.toString(bucket));
                        if(Integer.parseInt(bucket[2]) <= n) {
                            answer[idx++] = bucket[0];
                            n -= Integer.parseInt(bucket[2]);
                            standardTime += Integer.parseInt(bucket[2]);
                        } else {
                            bucket[2] = Integer.toString(Integer.parseInt(bucket[2])-n);
                            stack.add(bucket);
                            standardTime += n;
                            break;
                        }
                    }   
                }                
            }
        }
        
        answer[idx++] = plans[plans.length-1][0];
        
        while(!stack.isEmpty()) {
            String[] bucket = stack.pop();
            answer[idx++] = bucket[0];
        }
        
        return answer;
    }
    
    public static int toInt(String s) {
        String[] time = s.split(":");
        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        return h*60 + m;
    }
}