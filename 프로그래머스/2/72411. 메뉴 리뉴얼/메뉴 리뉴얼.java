import java.util.*;
class Solution {
        static Map<String, Integer> map;
    static List<String> list;
    static int[] sizeArr;
    public String[] solution(String[] orders, int[] course) {
        Arrays.sort(course);
        sizeArr = new int[course[course.length-1]+1];

        map = new HashMap<>();
        list = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            String[] arr = orders[i].split("");
            Arrays.sort(arr);
            for (int j = 0; j < course.length; j++) {
                comb(arr, new String[course[j]], 0, 0, course[j]);
            }
        }

        for(String s : map.keySet()) {
            for (int j : course) {
                if (j == s.length() && sizeArr[j] > 1 && map.get(s) == sizeArr[j]) {
                    list.add(s);
                }
            }
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public static void comb(String[] arr, String[] sel, int idx, int k, int num) {
        if(k == sel.length) {
            String bucket = "";
            for(String s : sel) {
                bucket += s;
            }
            map.put(bucket, map.getOrDefault(bucket, 0) + 1);
            sizeArr[num] = Math.max(sizeArr[num], map.get(bucket));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sel[k] = arr[i];
            comb(arr, sel, i+1, k+1, num);
        }
    }
}