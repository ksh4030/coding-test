import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int first = 0;
        int last = people.length - 1;
        
        while(first <= last) {
            if(people[first] + people[last] <= limit) {
                first++;
                last--;
            } else {
                last--;
            }
            answer++;
        }
        
        return answer;
    }
}