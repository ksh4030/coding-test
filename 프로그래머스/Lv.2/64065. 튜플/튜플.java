import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("\\{", "");
        s = s.substring(0, s.length()-2);
        String[] bucket = s.split("},");

        Arrays.sort(bucket, Comparator.comparing(String::length));
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < bucket.length; i++) {
            int[] arr = Arrays.stream(bucket[i].split(",")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < arr.length; j++) {
                if(!set.contains(arr[j])) {
                    list.add(arr[j]);
                }
                set.add(arr[j]);
            }
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}