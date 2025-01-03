import java.util.*;

class Solution {
    static Map<String, List<String>> give = new HashMap<>();
    static Map<String, List<String>> receive = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        initMap(friends, gifts);
        int[] res = predict(friends);
        return res[res.length-1];
    }
    
    public void initMap(String[] friends, String[] gifts) {
        for(String s : friends) {
            give.put(s, new LinkedList<>());
            receive.put(s, new LinkedList<>());
        }
        
        for(String s : gifts) {
            String[] arr = s.split(" ");
            give.get(arr[0]).add(arr[1]);
            receive.get(arr[1]).add(arr[0]);
        }
    }
    
    public int[] predict(String[] friends) {
        int[] res = new int[friends.length];
        
        for(int i=0; i<friends.length-1; i++) {
            for(int j=i+1; j<friends.length; j++) {
                String a = friends[i];
                String b = friends[j];
                
                int aNum = getGiveCnt(a, b);
                int bNum = getGiveCnt(b, a);
                
                if(aNum > bNum) {
                    res[i]++;
                } else if (bNum > aNum) {
                    res[j]++;
                } else {
                    int aGiftIdx = give.get(a).size() - receive.get(a).size();
                    int bGiftIdx = give.get(b).size() - receive.get(b).size();
                    
                    if(aGiftIdx > bGiftIdx) {
                        res[i]++;
                    } else if (bGiftIdx > aGiftIdx) {
                        res[j]++;
                    }
                }
            }
        }
        
        Arrays.sort(res);
        return res.clone();
    }
    
    public int getGiveCnt(String giveMan, String receiveMan) {
        int cnt = 0;
        for(int i=0; i<give.get(giveMan).size(); i++) {
            if(give.get(giveMan).get(i).equals(receiveMan)) cnt++;
        }
        return cnt;
    }
}