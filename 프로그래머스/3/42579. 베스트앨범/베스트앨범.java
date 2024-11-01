import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        List<String> mapList = new ArrayList<>(map.keySet());
        Collections.sort(mapList, (o1, o2) -> map.get(o2) - map.get(o1));
        
        for(String key : mapList) {
            for(int i=0; i<2; i++) {
                int idx = -1;
                int max = -1;
                for(int j=0; j<genres.length; j++) {
                    if(genres[j].equals(key)) {
                        if(max < plays[j]) {
                            max = plays[j];
                            idx = j;
                        }
                    }
                }
                if(idx >= 0) {
                    list.add(idx);
                    plays[idx] = -1;
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}