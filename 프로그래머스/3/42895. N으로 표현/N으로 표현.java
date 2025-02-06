import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        if(N == number) return 1;
        return find(N, number);
    }
    
    public int find(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0; i<=8; i++) {
            list.add(new HashSet<>());
        }
        list.get(1).add(N);

        for(int i=2; i<=8; i++) {
            int curNum = Integer.parseInt(String.valueOf(N).repeat(i));
            list.get(i).add(curNum);
            for(int j=1; j<i; j++) {
                for(int num1 : list.get(j)) {
                    for(int num2 : list.get(i-j)) {
                        list.get(i).add(num1 + num2);
                        list.get(i).add(num1 - num2);
                        list.get(i).add(num1 * num2);
                        if(num2 != 0) {
                            list.get(i).add(num1 / num2);
                        }
                    }
                }
            }
            if(list.get(i).contains(number)) return i;
        }
        return -1;
    }
}