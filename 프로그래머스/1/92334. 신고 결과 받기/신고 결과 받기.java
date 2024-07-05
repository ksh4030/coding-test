import java.util.*;
class Solution {    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, HashSet<String>> map = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i], new HashSet<String>());
        }
        
        for(int i=0; i<report.length; i++) {
            String[] bucket = report[i].split(" ");
            HashSet<String> set = map.get(bucket[1]);
            set.add(bucket[0]);
            map.put(bucket[1], set);
        }
        
        HashMap<String, Integer> ans = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            ans.put(id_list[i], 0);
        }
        
        for(String key : map.keySet()) {
            if(map.get(key).size() >= k) {
                List<String> list = new ArrayList<>(map.get(key));
                for(int i=0; i<list.size(); i++) {
                    ans.put(list.get(i), ans.get(list.get(i))+1);
                }
            }
        }
        
        for(int i=0; i<id_list.length; i++) {
            answer[i] = ans.get(id_list[i]);
        }
        
        return answer;
    }
}