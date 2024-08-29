import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        int size = n;
        int cur = k;
        
        for(String s : cmd) {
            String[] arr = s.split(" ");
            switch(arr[0]) {
                case "U":
                    cur -= Integer.valueOf(arr[1]);
                    break;
                case "D":
                    cur += Integer.valueOf(arr[1]);
                    break;
                case "C":
                    stack.add(cur);
                    size--;                    
                    if(size == cur) cur--;
                    break;
                case "Z":
                    int x = stack.pop();
                    if(x <= cur) {
                        cur++;                        
                    }
                    size++;
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; i++) sb.append("O");
        while(!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }
        answer = sb.toString();
        return answer;
    }
}