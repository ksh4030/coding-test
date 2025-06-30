import java.util.*;
class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static List<String> genre;
        
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> list = new ArrayList<>();
        init(genres, plays);
        
        for(String s : genre) {
            for(int t=0; t<2; t++) {
                int max = -1;
                int idx = -1;
                for(int i=0; i<genres.length; i++) {
                    if(s.equals(genres[i])) {
                        if(max < plays[i]) {
                            idx = i;
                            max = plays[i];
                        }
                    }
                }
                if (idx >= 0) {
                    list.add(idx);
                    plays[idx] = -1;
                }
            }
        }
                
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) answer[i] = list.get(i);
        
        return answer;
    }
    
    public void init(String[] genres, int[] plays) {
        for(int i=0; i<genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        genre = new ArrayList<>(map.keySet());
        Collections.sort(genre, (o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });
    }
}