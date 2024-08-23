import java.util.*;

class Solution {
    static Queue<int[]> q = new LinkedList<>();
    static List<int[]> sel = new ArrayList<>();
    static boolean[] v;
    
    public int solution(int n, int[] weak, int[] dist) {
        int answer = Integer.MAX_VALUE;
        v = new boolean[dist.length];
        
        makeWeak(weak, n);
        per(0, dist, new int[dist.length]);
        
        while (!q.isEmpty()) {
            int[] curWeak = q.poll();
            for (int[] curDist : sel) {
                int distIdx = 0; 
                int coveredPos = curWeak[0] + curDist[distIdx]; 
                
                int usedFriends = 1; 
                
                for (int i = 1; i < curWeak.length; i++) {
                    
                    if (curWeak[i] > coveredPos) {
                        usedFriends++;
                        if (usedFriends > curDist.length) break; 
                        distIdx++;
                        coveredPos = curWeak[i] + curDist[distIdx]; 
                    }
                }
                
                if (usedFriends <= curDist.length) {
                    answer = Math.min(answer, usedFriends);
                }
            }
        }
        
        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }
    
    public static void makeWeak(int[] weak, int n) {
        int len = weak.length;
        int[] extendedWeak = new int[len * 2];
        
        for (int i = 0; i < len; i++) {
            extendedWeak[i] = weak[i];
            extendedWeak[i + len] = weak[i] + n;
        }
        
        for (int i = 0; i < len; i++) {
            int[] tempWeak = Arrays.copyOfRange(extendedWeak, i, i + len);
            q.add(tempWeak);
        }
    }
    
    public static void per(int depth, int[] dist, int[] arr) {
        if (depth == dist.length) {
            sel.add(arr.clone());
            return;
        }
        
        for (int i = 0; i < dist.length; i++) {
            if (!v[i]) {
                v[i] = true;
                arr[depth] = dist[i];
                per(depth + 1, dist, arr);
                v[i] = false;
            }
        }
    }
}
