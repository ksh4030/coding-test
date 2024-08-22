public class Solution {
    static private int[] res = new int[11]; 
    static private int[] lion = {-1}; 
    static private int max = Integer.MIN_VALUE; 

    public static int[] solution(int n, int[] info) {
        back(0, n, info, 0); 
        if (max <= 0) { 
            return new int[]{-1};
        }
        return lion;
    }

    public static void back(int depth, int n, int[] info, int start) {
        if (depth == n) { 
            int diff = score(info);
            if (diff > max) { 
                max = diff;
                lion = res.clone();
            } else if (diff == max) { 
                for (int i = 10; i >= 0; i--) {
                    if (res[i] != lion[i]) {
                        if (res[i] > lion[i]) lion = res.clone();
                        break;
                    }
                }
            }
            return;
        }

        
        for (int i = start; i < 11; i++) {
            if (res[i] > info[i]) continue; 

            res[i]++;
            back(depth + 1, n, info, i); 
            res[i]--;
        }
    }

    public static int score(int[] info) {
        int apeach = 0, lionScore = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] == 0 && res[i] == 0) continue; 
            if (info[i] >= res[i]) apeach += (10 - i); 
            else lionScore += (10 - i); 
        }

        int diff = lionScore - apeach;
        return diff > 0 ? diff : -1; 
    }
}
