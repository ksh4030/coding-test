import java.util.*;
class Solution {
    public int[] solution(String msg) {
        String[] arr = msg.split("");
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int idx = 1;
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(i + "", idx++);
        }

        int max = 1;
        int last = 26;

        loop:
        for (int i = 0; i < arr.length; i++) {
            String s = "";
            String bucket = "";
            for (int j = i; j < i + max + 1; j++) {
                try {
                    s += arr[j];
                } catch (Exception e) {
                    list.add(map.get(s));
                    break loop;
                }

                if (!map.containsKey(s)) {
                    map.put(s, ++last);
                    list.add(map.get(bucket));
                    i=j-1;
                    if(s.length() > max) {
                        max = s.length();
                    }
                    break;
                }
                bucket = s;
            }

        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}