import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (int i = 0; i < arr.length; i++) {
            if(arr[0].equals("0")) {
                answer += arr[0];
                break;
            }
            answer+=arr[i];
        }
        return answer;
    }
}