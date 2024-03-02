import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> map.get(o2)-map.get(o1));

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int max = Integer.MIN_VALUE;
            int idx = -1;
            for (int j = 0; j < genres.length; j++) {
                if (list.get(i).equals(genres[j])) {
                    if (plays[j] > max) {
                        max = plays[j];
                        idx = j;
                    }
                }
            }

            ans.add(idx);
            if (max == map.get(list.get(i))) continue;
            plays[idx] = -1;
            max = Integer.MIN_VALUE;
            idx = -1;

            for (int j = 0; j < genres.length; j++) {
                if (list.get(i).equals(genres[j])) {
                    if (plays[j] > max) {
                        max = plays[j];
                        idx = j;
                    }
                }
            }
            ans.add(idx);
        }

        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}