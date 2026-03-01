import java.util.*;
class Solution {
    static String[][] operator = {
        {"*", "-", "+"},
        {"*", "+", "-"},
        {"-", "*", "+"},
        {"-", "+", "*"},
        {"+", "-", "*"},
        {"+", "*", "-"},
    };
    static List<String> list = new ArrayList<>();
    public long solution(String expression) {
        long answer = Integer.MIN_VALUE;
        
        init(expression);
        
        for(int i=0; i<operator.length; i++) {
            List<String> bucket = new ArrayList<>(list);
            
            for(int j=0; j<operator[i].length; j++) {
                for(int k=0; k<bucket.size(); k++) {
                    if(bucket.get(k).equals(operator[i][j])) {
                        cal(operator[i][j], k, bucket);
                        k--;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(Long.parseLong(bucket.get(0))));
        }
        
        return answer;
    }
    
    public void cal(String oper, int idx, List<String> bucket) {
        long x = Long.parseLong(bucket.get(idx-1));
        long y = Long.parseLong(bucket.get(idx+1));
        long num = 0;
        
        if(oper.equals("*")) {
            num = x*y;
        } else if (oper.equals("+")) {
            num = x+y;
        } else {
            num = x-y;
        }
        
        for(int i=0; i<3; i++) bucket.remove(idx-1);
        bucket.add(idx-1, Long.toString(num));
    }
    
    public void init(String expression) {
        String[] arr = expression.split("");
        String bucket = "";
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("*") || arr[i].equals("+") || arr[i].equals("-")) {
                list.add(bucket);
                list.add(arr[i]);
                bucket = "";
            } else {
                bucket += arr[i];
            }
        }
        list.add(bucket);
    }
}