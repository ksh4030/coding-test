import java.util.*;
class Solution {    
    public int solution(int n, int[] cores) {
        int answer = 0;
        int min = 0, max = 10_000 * n;
        int work = 0, time = 0;
        
        while(max >= min) {
            int mid = (max+min)/2;
            int cnt = cal(mid, cores);
            
            if(cnt >= n) {
                max = mid-1;
                time = mid;
                work = cnt;
            } else {
                min = mid+1;
            }
        }
        
        
        for(int i=cores.length-1; i>=0; i--) {
            if(time%cores[i] == 0) {
                if(work == n) {
                    answer = i+1;
                    break;
                }
                work--;
            }
        }
        return answer;
    }
    
    public static int cal(int mid, int[] cores) {
        int cnt = cores.length;
        for(int i=0; i<cores.length; i++) {
            cnt += (mid/cores[i]);
        }
        return cnt;
    }
}