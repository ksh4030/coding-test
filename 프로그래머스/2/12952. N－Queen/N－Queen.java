import java.util.*;
class Solution {
    static int ans = 0;
    static boolean[] arr;
    static boolean[] a;
    static boolean[] b;
    public int solution(int n) {
        int answer = 0;
        arr = new boolean[n];
        a = new boolean[2*n-1];
        b = new boolean[2*n-1];
        bt(0, n);
        
        return ans;
    }
    
    public void bt(int cur, int n) {
        if(cur == n) {
            ans++;
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(arr[i] || a[cur+i] || b[cur-i+n-1]) continue;
            arr[i] = a[cur+i] = b[cur-i+n-1] = true;
            bt(cur+1, n);
            arr[i] = a[cur+i] = b[cur-i+n-1] = false;
        }
    }
}
