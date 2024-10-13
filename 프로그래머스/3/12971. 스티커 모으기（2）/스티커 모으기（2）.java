import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length == 1) return sticker[0];
        int[] a = new int[sticker.length];
        int[] b = new int[sticker.length];
        
        a[0] = a[1] = sticker[0];
        b[1] = sticker[1];
        
        for(int i=2; i<sticker.length; i++) {
            if(i != sticker.length-1)a[i] = Math.max(a[i-2]+sticker[i], a[i-1]);            
            b[i] = Math.max(b[i-2]+sticker[i], b[i-1]);
        }

        return Math.max(a[a.length-2], b[b.length-1]);
    }
}