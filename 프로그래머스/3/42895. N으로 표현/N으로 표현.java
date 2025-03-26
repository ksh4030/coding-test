import java.util.*;
class Solution {
    static List<Set<Integer>> list = new ArrayList<>();
    public int solution(int N, int number) {
        if(N == number) return 1;
        
        for(int i=0; i<=8; i++) list.add(new HashSet<>());
        list.get(1).add(N);
        
        for(int i=2; i<=8; i++) {
            for(int j=1; j<i; j++) {
                for(int num1 : list.get(j)) {
                    for(int num2 : list.get(i-j)) {
                        list.get(i).add(num1 + num2);
                        list.get(i).add(num1 - num2);
                        list.get(i).add(num1 * num2);
                        if(num2 > 0) list.get(i).add(num1 / num2);
                        list.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
                    }
                }
            }
            for(int num : list.get(i)) if(num == number) return i;
        }
        
        return -1;
    }
}

