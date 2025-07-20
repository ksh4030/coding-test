import java.util.*;
class Solution {
    static String[][] cases = {
        {"+","-","*"},
        {"+","*","-"},
        {"*","-","+"},
        {"*","+","-"},
        {"-","+","*"},
        {"-","*","+"}
    };
    
    static List<Long> num = new ArrayList<>();
    static List<String> oper = new ArrayList<>();
    
    public long solution(String expression) {
        init(expression);
        return getMax();
    }
    
    public long getMax() {
        long max = 0;
        for(int i=0; i<cases.length; i++) {
            List<Long> n = new ArrayList<>();
            n.addAll(num);
            List<String> o = new ArrayList<>();
            o.addAll(oper);
            
            for(int j=0; j<cases[i].length; j++) {
                for(int k=0; k<o.size(); k++) {
                    if(o.get(k).equals(cases[i][j])) {
                        long bucket = cal(n.get(k), n.get(k+1), cases[i][j]);
                        n.remove(k+1);
                        n.remove(k);
                        o.remove(k);
                        
                        n.add(k, bucket);
                        k--;
                    }
                }
            }
            max = Math.max(max, Math.abs(n.get(0)));
        }
        return max;
    }
    
    public long cal(long a, long b, String c) {        
        switch(c) {
            case "*" :
                return a * b;
            case "+" :
                return a + b;
            case "-" :
                return a - b;
        }
        return -1;
    }
    
    public void init(String expression) {
        String bucket = "";
        for(int i=0; i<expression.length(); i++) {
            char cur = expression.charAt(i);
            
            if(cur == '*' || cur == '-' || cur == '+') {
                num.add(Long.parseLong(bucket));
                oper.add(String.valueOf(cur));
                bucket = "";
            } else {
                bucket += String.valueOf(cur);
            }
        }
        num.add(Long.parseLong(bucket));
    }
}